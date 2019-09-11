package com.ly.bletest1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ly.bletest1.Params.MSG_DATA;

public class MainActivity extends AppCompatActivity implements Toastinerface {

    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.rv_device)
    RecyclerView rvDevice;

    private String TAG = "bluetooth";
    private BluetoothAdapter bluetoothAdapter;
    private List<BluetoothDevice> deviceList = new ArrayList<>();
    private BluetoothDeviceAdapter listAdapter;
    private BluetoothBtReceiver btReceiver;
    private IntentFilter intentFilter;
    private ClientThread clientThread;
    private ServerThread serverThread;
    private Toastinerface mtoast;
    private Context mContext;

    private String pin = "1234";  //此处为你要连接的蓝牙设备的初始密钥，一般为1234或0000
    private boolean is;
    private final String ACTIONFILTER = "android.bluetooth.device.action.PAIRING_REQUEST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Log.e(TAG, "--------------- 不支持蓝牙");
            finish();
        }
        mtoast = this;
        mContext = this;
        final ExecutorService threadExecutor = Executors.newFixedThreadPool(1);
        listAdapter = new BluetoothDeviceAdapter(R.layout.item_adapter_bt_device,deviceList,this);
        rvDevice.setLayoutManager(new LinearLayoutManager(this));
        rvDevice.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.e(TAG, "accept:点击位置 ：" + position);
                itmClikPostion(position, threadExecutor);
            }
        });

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                try {
                    //通过工具类ClsUtils,调用createBond方法
                    BluetoothDevice btDevice = deviceList.get(position);
                    ClsUtils.createBond(btDevice.getClass(), btDevice);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 蓝牙未打开，询问打开
        if (!bluetoothAdapter.isEnabled()) {
            Intent turnOnBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOnBtIntent, Params.REQUEST_ENABLE_BT);
        }

        intentFilter = new IntentFilter();
        btReceiver = new BluetoothBtReceiver();
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(ACTIONFILTER);
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(btReceiver, intentFilter);
        btReceiver.SetPairlistener(new MakePariBlueToothListener() {
            @Override
            public void whilePari(BluetoothDevice device) {

            }

            @Override
            public void pairingSuccess(BluetoothDevice device) {
                listAdapter.notifyDataSetChanged();
                mtoast.toast("配对完成");
            }

            @Override
            public void cancelPari(BluetoothDevice device) {

            }
        });

        // 蓝牙已开启
        if (bluetoothAdapter.isEnabled()) {
            showBondDevice();
            // 默认开启服务线程监听
            if (serverThread != null) {
                serverThread.cancel();
            }
            Log.e(TAG, "-------------- new server thread");
            serverThread = new ServerThread(bluetoothAdapter, uiHandler);
            new Thread(serverThread).start();
        }
    }

    @OnClick({R.id.btn_search, R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                if (bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                }if (Build.VERSION.SDK_INT >= 6.0) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            Params.MY_PERMISSION_REQUEST_CONSTANT);
                }
                bluetoothAdapter.startDiscovery();
                break;
            case R.id.btn_send:
                Message message = new Message();
                message.what = Params.MSG_WRITE_DATA;
                message.obj = "com.liany.startCollection";
                uiHandler.sendMessage(message);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Params.REQUEST_ENABLE_BT: {
                if (resultCode == RESULT_OK) {
                    showBondDevice();
                }
                break;
            }
            case Params.REQUEST_ENABLE_VISIBILITY: {
                if (resultCode == 600) {
                    mtoast.toast("蓝牙已设置可见");
                } else if (resultCode == RESULT_CANCELED) {
                    mtoast.toast("蓝牙设置可见失败,请重试");
                }
                break;
            }
        }
    }

    private void itmClikPostion(int position, ExecutorService threadExecutor) {
        if (serverThread != null) {
            serverThread.cancel();
            serverThread = null;
            Log.e(TAG, "---------------client item click , cancel server thread ," +
                    "server thread is null");
        }
        final BluetoothDevice device1 = deviceList.get(position);
        // 开启客户端线程，连接点击的远程设备
        clientThread = new ClientThread(bluetoothAdapter, device1, uiHandler);
        threadExecutor.execute(clientThread);
//                new Thread(clientThread).start();
        clientThread.SetConnectBack(new ClientThread.ConnectBack() {
            @Override
            public void connectsuccess(BluetoothDevice device) {
                // 通知 ui 连接的服务器端设备
                Message message = new Message();
                message.what = Params.MSG_WRITE_DATA;
                message.obj = "com.liany.startCollection";
                uiHandler.sendMessage(message);
            }

            @Override
            public void connectfaile(BluetoothDevice device) {
                mtoast.toast("连接失败,请检查服务端是否打开。");
            }

            @Override
            public void connecting(BluetoothDevice device) {
                mtoast.toast("请稍等，正在连接中。");
            }
        });
    }

    /**
     * 用户打开蓝牙后，显示已绑定的设备列表
     */
    private void showBondDevice() {
        deviceList.clear();
        Set<BluetoothDevice> tmp = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice d : tmp) {
            deviceList.add(d);
        }
        listAdapter.notifyDataSetChanged();
    }

    public class BluetoothBtReceiver extends BroadcastReceiver {

        MakePariBlueToothListener mMakePariListener;

        public void SetPairlistener(MakePariBlueToothListener makePariBlueToothListener) {
            this.mMakePariListener = makePariBlueToothListener;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice btDevice = null;  //创建一个蓝牙device对象
            // 从Intent中获取设备对象
            btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                mtoast.toast("开始搜索 ...");
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                mtoast.toast("搜索结束");
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (isNewDevice(device)) {
                    deviceList.add(device);
                    listAdapter.notifyDataSetChanged();
                    Log.e(TAG, "---------------- " + device.getName());
                }
            } else if (ACTIONFILTER.equals(action)) {
                Log.e("action2=", action);
                Log.e("here", "btDevice.getName()");
                try {
                    //1.确认配对
                    ClsUtils.setPairingConfirmation(btDevice.getClass(), btDevice, true);
                    //2.终止有序广播
                    Log.i("order...", "isOrderedBroadcast:" + isOrderedBroadcast() + ",isInitialStickyBroadcast:" + isInitialStickyBroadcast());
                    abortBroadcast();//如果没有将广播终止，则会出现一个一闪而过的配对框。
                    //3.调用setPin方法进行配对...
                    boolean ret = ClsUtils.setPin(btDevice.getClass(), btDevice, pin);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {

                switch (btDevice.getBondState()) {
                    case BluetoothDevice.BOND_BONDING:// 正在配对
                        mMakePariListener.whilePari(btDevice);
                        break;
                    case BluetoothDevice.BOND_BONDED:// 配对结束
                        mMakePariListener.pairingSuccess(btDevice);
                        break;
                    case BluetoothDevice.BOND_NONE:// 取消配对/未配对
                        mMakePariListener.cancelPari(btDevice);
                    default:
                        break;
                }
            }
        }
    }
    public interface MakePariBlueToothListener {

        public void whilePari(BluetoothDevice device);

        public void pairingSuccess(BluetoothDevice device);

        public void cancelPari(BluetoothDevice device);
    }

    /**
     * 判断搜索的设备是新蓝牙设备，且不重复
     *
     * @param device
     * @return
     */
    private boolean isNewDevice(BluetoothDevice device) {
        boolean repeatFlag = false;
        for (BluetoothDevice d :
                deviceList) {
            if (d.getAddress().equals(device.getAddress())) {
                repeatFlag = true;
            }
        }
        //不是已绑定状态，且列表中不重复
        return device.getBondState() != BluetoothDevice.BOND_BONDED && !repeatFlag;
    }

    /**
     * 向 socket 写入发送的数据
     *
     * @param dataSend
     */
    public void writeData(String dataSend) {
//        Message message =new Message();
//        message.obj = dataSend;
//        if (serverThread!=null){
//            message.what=Params.MSG_SERVER_WRITE_NEW;
//            serverThread.writeHandler.sendMessage(message);
//        }
//        if (clientThread!=null){
//            message.what=Params.MSG_CLIENT_WRITE_NEW;
//            clientThread.writeHandler.sendMessage(message);
//        }
        if (serverThread != null) {
            serverThread.write(dataSend);
        } else if (clientThread != null) {
            clientThread.write(dataSend);
        }
    }

    /**
     * Toast 提示
     */
    @Override
    public void toast(String str) {
        Message message = new Message();
        Bundle bundle=new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);//bundle传值，耗时，效率低
        message.what = MSG_DATA;
        uiHandler.sendMessage(message);
    }

    @Override
    public void getResult(String result) {
        Activity activity = (Activity) mContext;
        if(activity == null) return;

        if(activity.isFinishing()) {
            return;
        }
        Message message = new Message();
        Bundle bundle=new Bundle();
        bundle.putString("data", result);
        message.setData(bundle);//bundle传值，耗时，效率低
        message.what = MSG_DATA;
        uiHandler.sendMessage(message);
    }

    @SuppressLint("HandlerLeak")
    Handler uiHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case Params.MSG_REV_A_CLIENT:
                    Log.e(TAG,"--------- uihandler set device name, go to data frag");
                    BluetoothDevice clientDevice = (BluetoothDevice) msg.obj;

                    break;
                case Params.MSG_CONNECT_TO_SERVER:
                    Log.e(TAG,"--------- uihandler set device name, go to data frag");
                    BluetoothDevice serverDevice = (BluetoothDevice) msg.obj;

                    break;
                case Params.MSG_SERVER_REV_NEW:
                    String newMsgFromClient = msg.obj.toString();
                    break;
                case Params.MSG_CLIENT_REV_NEW:
                    String newMsgFromServer = msg.obj.toString();
                    //接受消息,判断完成任务
                    mtoast.getResult(newMsgFromServer);
                    break;
                case Params.MSG_WRITE_DATA:
                    String dataSend = msg.obj.toString();
                    writeData(dataSend);
                    //发送消息

                    break;
                case Params.CONNECT_FAILE:
                    Log.e(TAG,"--------- connect faile");
                    mtoast.toast("连接失败");
                    break;
                case MSG_DATA:
                    Log.e(TAG,"--------- connect faile");
                    Toast.makeText(MainActivity.this,msg.getData().getString("data"),Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
