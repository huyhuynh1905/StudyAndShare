package com.huyhuynh.retrofitandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huyhuynh.retrofitandroid.model.TaiKhoan;
import com.huyhuynh.retrofitandroid.retrofit.LoginAPI;
import com.huyhuynh.retrofitandroid.view.SanPhamActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvMeassage;
    EditText edtEmail, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //xin quyền
        checkAndRequestPermissions();
    }

    private void init() {
        tvMeassage = findViewById(R.id.tvMessage);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.INTERNET
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                Map<String,String> map = new HashMap<>();
                map.put("email",email);
                map.put("pass",pass);
                LoginAPI.retrofitAPI.loginToServer(map).enqueue(new Callback<TaiKhoan>() {
                    @Override
                    public void onResponse(Call<TaiKhoan> call, Response<TaiKhoan> response) {
                        TaiKhoan taiKhoan = response.body();
                        if (taiKhoan!=null){
                            Toast.makeText(MainActivity.this,taiKhoan.getJwt(),Toast.LENGTH_LONG).show();
                            //chuyeern
                            Intent intent = new Intent(MainActivity.this, SanPhamActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,"Tài khoản null",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TaiKhoan> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Không kết nối được server",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}