package com.huyhuynh.serviceandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyBoundService extends Service {

    private IBinder binder = new ExampleBinder();

    @Override
    public void onCreate() {
        Toast.makeText(this,"onCreate BoundService! ",Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Phương thức này trả về chính là Interface để thao tác với service
        Toast.makeText(this,"onBind BoundService! ",Toast.LENGTH_LONG).show();
        return binder; //nó sẽ truyền về onServiceConnected() bên MainActivity
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"onUnbind BoundService! ",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"onDestroy BoundService! ",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public class ExampleBinder extends Binder{
        //Phương thức và class này trả về các đối tượng thao tác trong BoundService
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }

    public void getDataAfterGetService(){
        //Phương thức này có thể được gọi ở onServiceConnected() bên kia sau khi
        //lấy được bider trả về ở onBind()
        Toast.makeText(this,"getDataAfterGetService! ",Toast.LENGTH_LONG).show();
    }
}
