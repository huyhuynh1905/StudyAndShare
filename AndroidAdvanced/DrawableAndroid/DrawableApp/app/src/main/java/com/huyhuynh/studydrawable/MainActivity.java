package com.huyhuynh.studydrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        imageView = findViewById(R.id.imgAnh);
        imageView.setImageResource(R.drawable.hinhanh);
        btnNext = findViewById(R.id.btnButton);
        //Khai báo animation
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation); //load animation
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SubActivity.class));
                overridePendingTransition(R.anim.anim_alpha,R.anim.anim_rotate);
            }
        });
    }
}