package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSaveData, btnGetData;
    TextView txtHienThi;
    final String FILE_NAME = "huyhuynh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAndRequestPermissions();
        init();
        btnSaveData.setOnClickListener(this);
        btnGetData.setOnClickListener(this);
    }

    private void init() {
        btnSaveData = findViewById(R.id.btnSaveData);
        btnGetData = findViewById(R.id.btnGetData);
        txtHienThi = findViewById(R.id.txtHienThi);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSaveData:
                saveData();
                break;
            case R.id.btnGetData:
                readData();
                break;
        }
    }

    private void readData() {
        BufferedReader br;
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                FILE_NAME);
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line=br.readLine())!=null){
                stringBuilder.append(line);
            }
            txtHienThi.setText(stringBuilder.toString());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        FileOutputStream fileOutputStream = null;
        File file = null;
        String noidung ="Đây là nội dung đã lưu";
        try {
            //Dưới đây là lưu ở thư mục Download :))) đổi tham số để đổi vị trí lưu
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    FILE_NAME);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(noidung.getBytes());
            txtHienThi.setText("Save thành công!");
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
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

}
