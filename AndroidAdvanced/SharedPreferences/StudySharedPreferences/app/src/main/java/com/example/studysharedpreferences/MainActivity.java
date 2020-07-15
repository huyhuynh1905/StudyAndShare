package com.example.studysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    final String MY_NAME = "myName";
    final String MY_AGE = "myAge";
    final String IS_SINGLE = "isSingle";
    final String SAVE_CODE_SHARED = "huyhuynh";

    Button btnSaveData, btnGetData, btnRemove, btnRemoveAll;
    EditText edtName, edtAge;
    RadioButton radSingle, radNotSingle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeByKey();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
            }
        });
    }

    private void removeAll() {
        SharedPreferences sharedPreferences = getSharedPreferences(SAVE_CODE_SHARED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void removeByKey() {
        SharedPreferences sharedPreferences = getSharedPreferences(SAVE_CODE_SHARED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MY_NAME);
        editor.apply();
    }

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SAVE_CODE_SHARED, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MY_NAME,"Không tìm thấy");
        int age = sharedPreferences.getInt(MY_AGE,0);
        boolean single = sharedPreferences.getBoolean(IS_SINGLE,true);
        edtName.setText(name);
        edtAge.setText(age+"");
        if (single){
            radSingle.setChecked(true);
        } else {
            radNotSingle.setChecked(true);
        }
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SAVE_CODE_SHARED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name = edtName.getText().toString().trim();
        int age = Integer.parseInt(edtAge.getText().toString());
        boolean single = true;
        if (radNotSingle.isChecked()) single = false;
        editor.putString(MY_NAME,name);
        editor.putInt(MY_AGE,age);
        editor.putBoolean(IS_SINGLE,single);

        //lưu lại
        editor.apply();
    }

    private void init() {
        btnSaveData = findViewById(R.id.btnSaveData);
        btnGetData = findViewById(R.id.btnGetData);
        btnRemove = findViewById(R.id.btnRemove);
        btnRemoveAll = findViewById(R.id.btnRemoveAll);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        radSingle = findViewById(R.id.radSingle);
        radNotSingle = findViewById(R.id.radNotSingle);
    }
}
