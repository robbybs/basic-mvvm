package com.project.mvvmsample.repository;

import android.arch.lifecycle.MutableLiveData;

import com.project.mvvmsample.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private static RestaurantRepository instance;
    private ArrayList<Restaurant> dataset = new ArrayList<>();

    public static RestaurantRepository getInstance() {
        if (instance == null) {
            instance = new RestaurantRepository();
        }

        return instance;
    }

    public MutableLiveData<List<Restaurant>> getRestaurant() {
        setRestaurant();
        MutableLiveData<List<Restaurant>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setRestaurant() {
        dataset.add(new Restaurant("Cafe Brick", "travling.id:3000/resto/indoor/30da680510236f11d66e1f7b6a586fe7.jpg"));
        dataset.add(new Restaurant("Estuary Cafe", "travling.id:3000/resto/indoor/9832037c9be4cd12bbdacbc2976d9769.jpg"));
        dataset.add(new Restaurant("Maximillian Restaurant", "travling.id:3000/resto/indoor/9e9a6db1ea62119ffcbf3b2db800a8ee.jpg"));
        dataset.add(new Restaurant("Ayam Goreng Hayam Wuruk Jakal", "travling.id:3000/resto/indoor/3b90ec51da88cbb1832dafa2a4a58a1a.jpg"));
        dataset.add(new Restaurant("Balcony", "travling.id:3000/resto/indoor/120abf4a39180cca77f7e573b7d8bf1e.jpg"));
    }
}
