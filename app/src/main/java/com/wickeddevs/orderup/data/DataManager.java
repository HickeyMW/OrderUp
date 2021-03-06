package com.wickeddevs.orderup.data;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wickeddevs.orderup.data.ListObjects.DrinkListItem;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class DataManager {

    //private static DatabaseReference database = FirebaseDatabase.getInstance().getReference();;

    //Our local copy of the drink list
    //private static ArrayList<DrinkListItem> drinkList;
    Random random = new Random();
    private int orderNumber = 100;

    private static DataManager instance = null;
    private DataManager() {
        // Exists only to defeat instantiation.
    }

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }

        //Create the empty drink list
//        drinkList = new ArrayList<DrinkListItem>();
//
//        //When instantiated, we also want to set up our data listeners
//        ValueEventListener drinkListListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                //Get the drink list when it's changed
//                drinkList = dataSnapshot.getValue( ArrayList.class );
//
//            }
//
//            //For now we're going to ignore this
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        };

        //Listen for DrinkList changes (There shouldn't probably be any, but just in case)
        //database.child( "drinklist/" ).addValueEventListener( drinkListListener );

        return instance;
    }

    public ArrayList<Order> getDrinkOrders () {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            Order order = new Order();
            order.orderNumber = random.nextInt(1000);
            order.tableNumber = random.nextInt(100);
            order.items.add(new Drink(random.nextInt(20)));
            order.items.add(new Drink(random.nextInt(20)));
            orders.add(order);
        }
        return orders;
    }

    public ArrayList<Order> getFoodAppetizers () {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            Order order = new Order();
            order.orderNumber = random.nextInt(1000);
            order.tableNumber = random.nextInt(100);
            order.items.add(new Food(random.nextInt(13)));
            order.items.add(new Appetizer(random.nextInt(5)));
            orders.add(order);
        }
        return orders;
    }

    public ArrayList<Table> getTables () {
        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            Table table = new Table();
            table.tableNumber = random.nextInt(100);
            table.appetizerStatus = random.nextInt(4);
            table.drinkStatus = random.nextInt(4);
            table.foodStatus = random.nextInt(4);
            tables.add(table);
        }
        return tables;
    }

    //Adds a drink to the drink list in the database
    //Parameter is an array in the format { String name, String price }
//    public static void addToDrinkList( DrinkListItem drink ){
//
//        //Add this drink to the drink list
//        drinkList.add( drink );
//
//        //Update the database with the new drink list
//        //This will get increasingly expensive as the drink list grows but I'm banking on it not being like n = 100,000
//        database.child( "drinklist/" ).setValue( drinkList );
//
//    }

    //Gets a list of all orderable drinks from the database
    //Each is in the format { String name, String price }
    //This returns an automatically updated snapshot of the DrinkList database
//    public static ArrayList<DrinkListItem> getDrinkList(){
//        return drinkList;
//    }

}
