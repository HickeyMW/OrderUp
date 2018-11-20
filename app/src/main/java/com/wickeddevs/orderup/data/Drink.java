package com.wickeddevs.orderup.data;

//import Item;

public class Drink extends Item {

    public int id = -1;
    public String name = "";
    public double price = 0.0;

    // Drink constructor
    public Drink ( int id, String name, double price ) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
