package com.wickeddevs.orderup.ui.kitchen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public class KitchenActivity extends AppCompatActivity implements KitchenContract.View {

    RecyclerView rvKitchen;
    KitchenRVA kitchenRVA;
    KitchenContract.ViewListener viewListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        viewListener = new KitchenPresenter(this);
        setTitle("Kitchen Activity");
        rvKitchen = findViewById(R.id.rvKitchen);
        viewListener.getOrders();
    }

    @Override
    public void initialOrders(ArrayList<Order> orders) {
        rvKitchen.setLayoutManager(new LinearLayoutManager(this));
        kitchenRVA = new KitchenRVA(this, orders);
        rvKitchen.setAdapter(kitchenRVA);
    }

    @Override
    public void addOrder(Order order) {

    }
}
