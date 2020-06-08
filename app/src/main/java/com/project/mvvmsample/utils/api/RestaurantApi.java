package com.project.mvvmsample.utils.api;

import com.project.mvvmsample.model.ResponseRestaurant;
import com.project.mvvmsample.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantApi {
    @GET("restaurant/popular_restaurant_num/0")
    Call<Result<ResponseRestaurant>> getRestaurantData();
}
