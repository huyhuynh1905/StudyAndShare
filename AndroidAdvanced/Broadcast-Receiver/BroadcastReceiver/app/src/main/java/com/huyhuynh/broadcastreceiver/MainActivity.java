package com.huyhuynh.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onStart() {
        super.onStart();
        //initBroadcastReceiverNetworkChange();
        customBroadCastReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Phải huỷ đăng kí lắng nghe khi dừng activity để tránh crash app
        unregisterReceiver(myReceiver);
    }

    //Khởi tạo nhận thông báo lắng nghe thay đổi mạng
    public void initBroadcastReceiverNetworkChange(){
        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, filter);
    }

    public static final String CUSTOM_BR = "customBR";
    //Lắng nghe sự kiện khi bấm button
    public void customBroadCastReceiver(){
        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CUSTOM_BR);
        registerReceiver(myReceiver, filter);
    }
    //Code khi bấm vào button
    public void sendingBroadcastReceiver(View view) {
        Intent intent = new Intent();
        intent.setAction(CUSTOM_BR);
        intent.putExtra("data","Notice me senpai!");
        sendBroadcast(intent);
    }
}
