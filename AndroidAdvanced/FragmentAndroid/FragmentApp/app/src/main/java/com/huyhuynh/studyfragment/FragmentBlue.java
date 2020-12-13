package com.huyhuynh.studyfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentBlue extends Fragment {
    private Button btnShowRed;
    private View blueView;
    private OnRedClickButtonListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        blueView = inflater.inflate(R.layout.fragment_blue,container,false);
        init();
        control();
        return blueView;
    }

    public void setListener(OnRedClickButtonListener listener) {
        this.listener = listener;
    }

    private void control() {
        btnShowRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickButton();
            }
        });
    }


    private void init() {
        btnShowRed = blueView.findViewById(R.id.btnShowRed);
    }

    public interface OnRedClickButtonListener{
        void clickButton();
    }
}
