package com.huyhuynh.studyfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentRed fragmentRed;
    FragmentBlue fragmentBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBlueFragment();
    }

    private void showRedFragment() {
        if (fragmentRed==null){
            fragmentRed = new FragmentRed();
            //Code này để dùng interface ở fragment
            fragmentRed.setListener(new FragmentRed.OnBlueClickButtonListener() {
                @Override
                public void clickButton() {
                    showBlueFragment();
                }
            });
        }
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out,R.anim.anim_left_in,R.anim.anim_left_out)
                .replace(R.id.layout_activity,fragmentRed,FragmentRed.class.getName())
                .addToBackStack(null)
                .commit();
    }

    private void showBlueFragment() {
        if (fragmentBlue==null){
            fragmentBlue = new FragmentBlue();
            fragmentBlue.setListener(new FragmentBlue.OnRedClickButtonListener() {
                @Override
                public void clickButton() {
                    showRedFragment();
                }
            });
        }
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out,R.anim.anim_left_in,R.anim.anim_left_out)
                .replace(R.id.layout_activity,fragmentBlue,FragmentRed.class.getName())
                .addToBackStack(null)
                .commit();
    }
}