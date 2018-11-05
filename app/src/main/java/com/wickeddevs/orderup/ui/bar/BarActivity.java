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
import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity implements BarContract.View {

    RecyclerView rvBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        setTitle("Bar Activity");
        rvBar = findViewById(R.id.rvBar);
        rvBar.setLayoutManager(new LinearLayoutManager(this));
        rvBar.setAdapter(new BarRVA(this));

    }

    @Override
    public void initialOrders(ArrayList<Order> orders) {

    }

    @Override
    public void addOrder(Order order) {

    }
}
