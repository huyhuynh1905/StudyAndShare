package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtHienThi;
    Button btnSaveData, btnGetData;
    final String FILE_NAME = "huyhuynh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnSaveData.setOnClickListener(this);
        btnGetData.setOnClickListener(this);
    }

    private void init() {
        btnGetData = findViewById(R.id.btnGetData);
        btnSaveData = findViewById(R.id.btnSaveData);
        txtHienThi = findViewById(R.id.txtHienThi);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSaveData:
                saveData();
                break;
            case R.id.btnGetData:
                readDate();
                break;
        }
    }

    private void readDate() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line=br.readLine())!=null){
                stringBuilder.append(line);
            }
            txtHienThi.setText(stringBuilder.toString());
            br.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        FileOutputStream fileOutputStream = null;
        String noidung = "Xin chào, đây là nội dung đã lưu!";
        try {
            fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(noidung.getBytes());
            fileOutputStream.close();
            txtHienThi.setText("Lưu file thành công!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
