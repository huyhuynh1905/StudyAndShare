package com.example.studyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InfoActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLiDangNhap();
            }
        });
    }

    private void xuLiDangNhap() {
        String user = edtUsername.getText().toString();
        String pass = edtPass.getText().toString();
        if (user.equals("huy")&&pass.equals("123")){
            Intent intent = new Intent();
            intent.putExtra("mess","Đăng Nhập Thành Công!");
            setResult(RESULT_OK,intent);
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra("mess","Đăng Nhập Thất Bại!");
            setResult(RESULT_CANCELED,intent);
            finish();
        }
    }

    private void init() {
        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
    }
}
