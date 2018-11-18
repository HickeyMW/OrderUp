package com.wickeddevs.orderup.ui.bar;

import com.wickeddevs.orderup.data.DataManager;
import com.wickeddevs.orderup.data.Drink;
import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public class BarPresenter implements BarContract.ViewListener {

    BarContract.View view;

    public BarPresenter(BarContract.View view) {
        this.view = view;
    }

    @Override
    public void getOrders() {

        ArrayList<Order> orders = DataManager.getInstance().getBarOrders();

        System.out.println( "Got orders " + orders.size() );

        view.initialOrders( orders );
    }

    @Override
    public void orderCompleted(Order order) {

    }
}
