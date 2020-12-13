package com.huyhuynh.studyfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentRed extends Fragment {
    private Button btnShowBlue;
    private View redView;
    private OnBlueClickButtonListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        redView = inflater.inflate(R.layout.fragment_red,container,false);
        init();
        control();
        return redView;
    }

    public void setListener(OnBlueClickButtonListener listener) {
        this.listener = listener;
    }

    private void control() {
        btnShowBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickButton();
            }
        });
    }

    private void init() {
        btnShowBlue = redView.findViewById(R.id.btnShowBlue);
    }

    public interface OnBlueClickButtonListener{
        void clickButton();
    }
}
