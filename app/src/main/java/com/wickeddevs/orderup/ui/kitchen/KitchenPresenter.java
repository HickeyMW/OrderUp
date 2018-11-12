package com.wickeddevs.orderup.ui.kitchen;

import com.wickeddevs.orderup.data.Order;

public class KitchenPresenter implements KitchenContract.ViewListener {

    KitchenContract.View view;

    public KitchenPresenter(KitchenContract.View view) {
        this.view = view;
    }

    @Override
    public void getOrders() {

    }

    @Override
    public void orderCompleted(Order order) {

    }
}
