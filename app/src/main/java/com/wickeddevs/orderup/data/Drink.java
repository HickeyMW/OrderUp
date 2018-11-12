package com.wickeddevs.orderup.data;

//import Item;

public class Drink extends Item {

    // Drink constructor
    public Drink (int id) {
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




    // Name Enums - Not sure if necessary
    public static final int Margarita= 0 ;
    public static final int WhiteRussian= 1 ;
    public static final int SexOnTheBeach= 2;
    public static final int BlowJob= 3;
    public static final int Mojito= 4;
    public static final int B52= 5;
    public static final int BudLight= 6;
    public static final int MillerLight= 7;
    public static final int CoorsLight= 8;
    public static final int Hamms= 9;
    public static final int Corona= 10;
    public static final int LandShark= 11;
    public static final int Chardonnay= 12;
    public static final int Cabernet= 13;
    public static final int Moscato= 14;
    public static final int Champagne= 15;
    public static final int Riesling= 16;
    public static final int PinotNoir= 17;
    public static final int Merlot= 18;
    public static final int PinotGrigio= 19;
    public static final int SauvignonBlanc= 20;

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


    //    // Price enums
//    public static final int Zero = 0;
//    public static final int One = 1;
//    public static final int Two = 2;
//    public static final int Three = 3;
//    public static final int Four = 4;
//    public static final int Five = 5;
//    public static final int Six = 6;
//    public static final int Seven = 7;
//    public static final int Eight = 8;
//    public static final int Nine = 9;
//    public static final int Ten = 10;
//    public static final int Eleven = 11;
//    public static final int Twelve = 12;
//    public static final int Thirteen = 13;
//    public static final int Fourteen = 14;
//    public static final int Fifteen = 15;
//    public static final int Sixteen = 16;
//    public static final int Seventeen = 17;
//    public static final int Eighteen = 18;
//    public static final int Nineteen = 19;
//    public static final int Twenty = 20;


}
