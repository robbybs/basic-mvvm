package com.project.mvvmsample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.mvvmsample.R;
import com.project.mvvmsample.adapter.RestaurantAdapter;
import com.project.mvvmsample.model.Restaurant;
import com.project.mvvmsample.viewmodel.RestaurantViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RestaurantViewModel restaurantViewModel;
    private RestaurantAdapter restaurantAdapter;
    private RecyclerView rvRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRestaurant = findViewById(R.id.rv_restaurant);
        // MVVM use data binding
//        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        activityMainBinding.setViewModel(new LoginViewModel());
//        activityMainBinding.executePendingBindings();

        // MVVM use live data
        restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        restaurantViewModel.initData();
        restaurantViewModel.getRestaurant().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(@Nullable List<Restaurant> restaurants) {
                restaurantAdapter.notifyDataSetChanged();
            }
        });
        setRecyclerView();
    }

    private void setRecyclerView() {
        restaurantAdapter = new RestaurantAdapter(restaurantViewModel.getRestaurant().getValue(), this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvRestaurant.setLayoutManager(linearLayoutManager);
        rvRestaurant.setAdapter(restaurantAdapter);
    }

//    @BindingAdapter({"toastMessage"})
//    public static void runMe(View view, String message) {
//        if (message != null)
//            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
//    }
}
