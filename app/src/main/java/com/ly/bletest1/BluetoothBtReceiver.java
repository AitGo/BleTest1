package com.ly.bletest1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @创建者 ly
 * @创建时间 2019/9/3
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
//public class BluetoothBtReceiver extends BroadcastReceiver {
//
//    MakePariBlueToothListener mMakePariListener;
//
//    public void SetPairlistener(MakePariBlueToothListener makePariBlueToothListener) {
//        this.mMakePariListener = makePariBlueToothListener;
//    }
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String action = intent.getAction();
//        BluetoothDevice btDevice = null;  //创建一个蓝牙device对象
//        // 从Intent中获取设备对象
//        btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//
//        if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
//            mtoast.toast("开始搜索 ...");
//        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
//            mtoast.toast("搜索结束");
//        } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//            if (isNewDevice(device)) {
//                deviceList.add(device);
//                listAdapter.notifyDataSetChanged();
//                Log.e(TAG, "---------------- " + device.getName());
//            }
//        } else if (ACTIONFILTER.equals(action)) {
//            Log.e("action2=", action);
//            Log.e("here", "btDevice.getName()");
//            try {
//                //1.确认配对
//                ClsUtils.setPairingConfirmation(btDevice.getClass(), btDevice, true);
//                //2.终止有序广播
//                Log.i("order...", "isOrderedBroadcast:" + isOrderedBroadcast() + ",isInitialStickyBroadcast:" + isInitialStickyBroadcast());
//                abortBroadcast();//如果没有将广播终止，则会出现一个一闪而过的配对框。
//                //3.调用setPin方法进行配对...
//                boolean ret = ClsUtils.setPin(btDevice.getClass(), btDevice, pin);
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } else if (action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
//
//            switch (btDevice.getBondState()) {
//                case BluetoothDevice.BOND_BONDING:// 正在配对
//                    mMakePariListener.whilePari(btDevice);
//                    break;
//                case BluetoothDevice.BOND_BONDED:// 配对结束
//                    mMakePariListener.pairingSuccess(btDevice);
//                    break;
//                case BluetoothDevice.BOND_NONE:// 取消配对/未配对
//                    mMakePariListener.cancelPari(btDevice);
//                default:
//                    break;
//            }
//        }
//    }
//
//    public interface MakePariBlueToothListener {
//
//        public void whilePari(BluetoothDevice device);
//
//        public void pairingSuccess(BluetoothDevice device);
//
//        public void cancelPari(BluetoothDevice device);
//    }
//
//    /**
//     * 判断搜索的设备是新蓝牙设备，且不重复
//     *
//     * @param device
//     * @return
//     */
//    private boolean isNewDevice(BluetoothDevice device) {
//        boolean repeatFlag = false;
//        for (BluetoothDevice d :
//                deviceList) {
//            if (d.getAddress().equals(device.getAddress())) {
//                repeatFlag = true;
//            }
//        }
//        //不是已绑定状态，且列表中不重复
//        return device.getBondState() != BluetoothDevice.BOND_BONDED && !repeatFlag;
//    }
//}
