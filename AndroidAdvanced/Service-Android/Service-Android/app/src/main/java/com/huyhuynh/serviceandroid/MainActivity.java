package com.huyhuynh.serviceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huyhuynh.serviceandroid.service.MyBoundService;
import com.huyhuynh.serviceandroid.service.MyStartService;

public class MainActivity extends AppCompatActivity{

    Button btnStart,btnDes, btnBoundStart, btnBoundStop;
    private MyBoundService myBoundService = null;
    private boolean iCheckBoundService = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        myServiceStartService();
        myServiceBoundService();
    }


    private void myServiceStartService() {
        final Intent intent = new Intent(this, MyStartService.class);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"btnStart!",Toast.LENGTH_LONG).show();
                //put một data
                intent.putExtra("data","Data from Intent");
                startService(intent);
            }
        });
        btnDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"btnStop!",Toast.LENGTH_LONG).show();
                stopService(intent);
            }
        });
    }


    private void myServiceBoundService() {
        final Intent intent = new Intent(this, MyBoundService.class);
        btnBoundStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });
        btnBoundStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iCheckBoundService){
                    unbindService(serviceConnection);
                    iCheckBoundService = false;
                }
            }
        });
    }

    //Phương thức service phải khai báo biến serviceConnection
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //Phương thức này được gọi khi service được kết nối (sau onBind)
            MyBoundService.ExampleBinder binder = (MyBoundService.ExampleBinder) service;
            myBoundService = binder.getService(); //Get được service
            myBoundService.getDataAfterGetService(); //Có thể gọi được phương thức service
            iCheckBoundService = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //Chỉ được gọi khi xảy ra lỗi, hoặc bị ngắt đột ngột
            //Không gọi khi chủ động ngắt kết nối
            iCheckBoundService = false;
        }
    };

    private void init() {
        btnStart = findViewById(R.id.btnStart);
        btnDes = findViewById(R.id.btnDes);
        btnBoundStart = findViewById(R.id.btnStartBound);
        btnBoundStop = findViewById(R.id.btnBoundDes);
    }

}
