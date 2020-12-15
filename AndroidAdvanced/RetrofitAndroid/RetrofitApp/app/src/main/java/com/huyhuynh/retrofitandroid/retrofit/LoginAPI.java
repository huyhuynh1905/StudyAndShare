package com.huyhuynh.retrofitandroid.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huyhuynh.retrofitandroid.model.TaiKhoan;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {
    String baseUrl = "http://192.168.1.101:8081/"; //domain url
    Gson gsonn = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    LoginAPI retrofitAPI = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gsonn))
            .build()
            .create(LoginAPI.class);

    //Các API sẽ call
    @POST("login")
    Call<TaiKhoan> loginToServer(@Body Map<String,String> map);
}
