package com.wickeddevs.orderup.ui.kitchen;

import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public interface KitchenContract {

    interface View {
        void initialOrders(ArrayList<Order> orders);

        void addOrder(Order order);
    }

    interface ViewListener {
        void getOrders();

        void orderCompleted(Order order);
    }
}
