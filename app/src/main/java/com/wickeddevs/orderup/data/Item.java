package com.wickeddevs.orderup.data;

public abstract class Item {
    int ID;
    double cost;
    String modifications;
    String name;

    public void addToOrder(){
        Order.push(this);
    }






}
