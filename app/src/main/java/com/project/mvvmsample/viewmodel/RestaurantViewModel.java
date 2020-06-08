package com.project.mvvmsample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.project.mvvmsample.model.Restaurant;
import com.project.mvvmsample.repository.RestaurantRepository;

import java.util.List;

public class RestaurantViewModel extends ViewModel {
    private MutableLiveData<List<Restaurant>> restaurantList;

    public LiveData<List<Restaurant>> getRestaurant() {
        return restaurantList;
    }

    public void initData() {
        if (restaurantList != null) {
            return;
        }

        RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();
        restaurantList = restaurantRepository.getRestaurant();
    }
}
