package com.wickeddevs.orderup.data;

public class Appetizer extends Item {

    public Appetizer (int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return names[id];
    }

    @Override
    public double getPrice() {
        return prices[id];
    }

    // Drink Array
    private static String[] names = {
            "Fried Pickles",
            "Mini Tacos",
            "Mozerella Sticks",
            "Onion Rings",
            "Buffalo Wings"

    };



    // Price Array
    private static double[] prices = { 4.99, 4.99, 4.99, 4.99, 4.99};


}
