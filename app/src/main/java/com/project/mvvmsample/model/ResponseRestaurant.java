package com.project.mvvmsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseRestaurant {
    @SerializedName("most_popular")
    @Expose
    private List<Restaurant> getRestaurantData;

    public List<Restaurant> getGetRestaurantData() {
        return getRestaurantData;
    }
}
