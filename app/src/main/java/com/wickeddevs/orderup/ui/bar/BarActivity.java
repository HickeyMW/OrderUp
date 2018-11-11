package com.wickeddevs.orderup.ui.bar;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.DataManager;
import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity implements BarContract.View {

    RecyclerView rvBar;
    BarRVA barRVA;
    BarContract.ViewListener viewListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        viewListener = new BarPresenter(this);
        setTitle("Bar Activity");
        rvBar = findViewById(R.id.rvBar);

        //Spin up the data manager and get the drink list just for fun
        DataManager.getInstance().getDrinkList();

        viewListener.getOrders();

    }

    @Override
    public void initialOrders(ArrayList<Order> orders) {
        rvBar.setLayoutManager(new LinearLayoutManager(this));
        barRVA = new BarRVA(this, orders);
        rvBar.setAdapter(barRVA);
    }

    @Override
    public void addOrder(Order order) {
        barRVA.addOrder(order);
    }
}
