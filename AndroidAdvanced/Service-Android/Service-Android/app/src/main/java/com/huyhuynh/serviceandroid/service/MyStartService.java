package com.huyhuynh.serviceandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.huyhuynh.serviceandroid.MainActivity;

public class MyStartService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Đây là phương thức bắt buộc viết lại khi extend, phương thức này dành cho Bound Service
        return null;
    }

    @Override
    public void onCreate() {
        //Phương thức này chỉ chạy một lần duy nhất khi khởi chạy Service
        Toast.makeText(this,"onCreate!",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Phương thức này chứa code xử lí cho service đang chạy
        String data = intent.getStringExtra("data");
        Toast.makeText(this,"onStartCommand! "+data,Toast.LENGTH_LONG).show();
        //ở đây sẽ return về một trong các giá trị như:
        return START_STICKY;
        //return START_NOT_STICKY;
        //return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        //Phương thức này xử lí code khi service kết thúc
        Toast.makeText(this,"onDestroy!",Toast.LENGTH_LONG).show();
    }
}
