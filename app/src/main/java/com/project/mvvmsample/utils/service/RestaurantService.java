package com.project.mvvmsample.utils.service;

import com.project.mvvmsample.utils.okhttp3.UnsafeOkHttpClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantService {
    private static final String BASE_URL = "https://travling.id:3000/";

    public static Retrofit getAPI() {
        OkHttpClient client = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
