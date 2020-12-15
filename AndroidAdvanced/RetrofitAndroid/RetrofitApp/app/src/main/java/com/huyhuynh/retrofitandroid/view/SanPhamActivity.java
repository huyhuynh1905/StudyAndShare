package com.huyhuynh.retrofitandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.huyhuynh.retrofitandroid.R;
import com.huyhuynh.retrofitandroid.adapter.SanPhamAdapter;
import com.huyhuynh.retrofitandroid.model.SanPham;
import com.huyhuynh.retrofitandroid.retrofit.SanPhamAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamActivity extends AppCompatActivity {

    RecyclerView rcvSanPham;
    SanPhamAdapter sanPhamAdapter;
    List<SanPham> sanPhamListt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        init();
        loadAllSanPham();
        rcvSanPham.setAdapter(sanPhamAdapter);
    }

    private void init() {
        rcvSanPham = findViewById(R.id.rcvSanPham);
        sanPhamAdapter = new SanPhamAdapter(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvSanPham.setLayoutManager(layoutManager);

    }

    public void loadAllSanPham(){
        SanPhamAPI.retrofitAPI.getAllSanPham().enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                //Call thành công
                sanPhamListt = response.body();
                if (sanPhamListt==null){
                    Log.d("ERROR READ","List Null");
                    return;
                }
                sanPhamAdapter.setList(sanPhamListt);
                sanPhamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                //Call thất bại
                Log.d("ERROR API",t.toString());
            }
        });
    }
}