package com.ly.bletest1;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @创建者 ly
 * @创建时间 2019/9/3
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class BluetoothDeviceAdapter extends BaseQuickAdapter<BluetoothDevice,BaseViewHolder> {

    private Context mContext;

    public BluetoothDeviceAdapter(int layoutResId, @Nullable List<BluetoothDevice> data,Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BluetoothDevice item) {
        int code = item.getBondState();
        String name = item.getName();
        String mac = item.getAddress();
        String state;

        if (name == null || name.length() == 0) {
            name = "未命名设备";
        }
//        if (code == BluetoothDevice.BOND_BONDED) {
//            state = "已配对";
//            helper.setTextColor(R.id.device_state,mContext.getResources().getColor(R.color.green));
//        } else {
//            state = "未配对";
//            helper.setTextColor(R.id.device_state,mContext.getResources().getColor(R.color.red));
//        }
        if (mac == null || mac.length() == 0) {
            mac = "未知 mac 地址";
        }

        helper.setText(R.id.device_name,name)
                .setText(R.id.device_mac,mac)
//                .setText(R.id.device_state,state)
                .addOnClickListener(R.id.device_pair);
        if (code == BluetoothDevice.BOND_BONDED) {
            helper.setText(R.id.device_pair,"已配对");
        }

    }
}
