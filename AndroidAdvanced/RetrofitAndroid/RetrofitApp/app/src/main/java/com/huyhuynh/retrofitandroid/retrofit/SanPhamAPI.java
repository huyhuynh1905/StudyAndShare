package com.huyhuynh.retrofitandroid.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huyhuynh.retrofitandroid.model.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface SanPhamAPI{

    String baseUrl = "http://192.168.1.101:8081/";
    Gson gsonn = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    SanPhamAPI retrofitAPI = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gsonn))
            .build()
            .create(SanPhamAPI.class);

    @GET("sanpham")
    Call<List<SanPham>> getAllSanPham();
}
