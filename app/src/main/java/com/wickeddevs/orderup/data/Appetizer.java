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
            "Margarita",
            "White Russian",
            "Sex on the Beach",
            "Blowjob",
            "Mojito",
            "B-52",
            "Bud Light",
            "Miller Light",
            "Coors Light",
            "Hamms",
            "Corona Extra",
            "Landshark",
            "Chardonnay",
            "Cabernet",
            "Moscato",
            "Champagne",
            "Riesling",
            "PinotNoir",
            "Merlot",
            "PinotGrigio",
            "Sauvignon Blanc"

    };



    // Price Array
    private static double[] prices = { 4.99, 4.99, 4.99, 4.99, 4.99, 3.49, 3.49, 3.49, 3.49, 3.49,
            4.49, 4.49, 4.49, 4.49, 4.49, 5.49, 5.49, 5.49, 5.49, 5.49};


}
