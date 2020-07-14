package com.huyhuynh.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Code xử lí nếu có thay đổi mạng
        Toast.makeText(context,"Mạng On/Off",Toast.LENGTH_LONG).show();
        //Code xử lí custom Acction
        if (intent.getAction().equals(MainActivity.CUSTOM_BR)){
            String data = intent.getStringExtra("data");
            Toast.makeText(context,data,Toast.LENGTH_LONG).show();
        }
    }
}
