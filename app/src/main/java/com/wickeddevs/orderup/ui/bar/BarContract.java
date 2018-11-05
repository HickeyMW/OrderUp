package com.wickeddevs.orderup.ui.bar;

import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public interface BarContract {

    interface View {
        void initialOrders(ArrayList<Order> orders);

        void addOrder(Order order);
    }

    interface ViewListener {
        void getOrders();

        void orderCompleted(Order order);
    }
}
