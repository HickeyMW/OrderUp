package com.wickeddevs.orderup.ui.bar;

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

        //Only use as an example
        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.items.add(new Drink(0));
        order.items.add(new Drink(1));
        Order order2 = new Order();
        order2.items.add(new Drink(2));
        order2.items.add(new Drink(3));
        order2.items.add(new Drink(4));
        orders.add(order);
        orders.add(order2);

        view.initialOrders(orders);
    }

    @Override
    public void orderCompleted(Order order) {

    }
}
