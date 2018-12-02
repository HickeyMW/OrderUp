package com.wickeddevs.orderup.data;

//import Item;

public class Food extends Item {

    public Food (int id) {
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
            "Pizza",
            "Burger",
            "Ribs",
            "Steak",
            "Mac n' Cheese",
            "Soup of the Day",
            "Cod",
            "Tacos",
            "Burrito",
            "Sandwich",
            "Chicken Fingers",
            "Chicken Sandwich",
            "Chardonnay",
            "Quesadilla"

    };



    // Price Array
    private static double[] prices = { 4.99, 4.99, 4.99, 4.99, 4.99, 3.49, 3.49, 3.49, 3.49, 3.49,
            4.49, 4.49};




}
