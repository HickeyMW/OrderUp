package com.wickeddevs.orderup.data;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wickeddevs.orderup.data.ListObjects.DrinkListItem;

import java.io.Console;
import java.util.ArrayList;

public class DataManager {

    private static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    //Our local copy of the drink list
    private static ArrayList<DrinkListItem> drinkList;

    private static ArrayList<Order> barOrders;

    private static DataManager instance = null;
    private DataManager() {
        // Exists only to defeat instantiation.
    }

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }

        //Create the empty drink list
        drinkList = new ArrayList<DrinkListItem>();

        //Create the empty bar orders list
        barOrders = new ArrayList<Order>();

        //Set up data listeners

        //Drink list listener
        ValueEventListener drinkListListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Get the drink list when it's changed
                drinkList = dataSnapshot.getValue( ArrayList.class );

            }

            //For now we're going to ignore this
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        //Listen for DrinkList changes (There shouldn't probably be any, but just in case)
        database.child( "drinklist" ).addValueEventListener( drinkListListener );

        //Bar order list listener
        ValueEventListener barOrderListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Get the bar orders when it's changed
                barOrders = dataSnapshot.getValue( ArrayList.class );

            }

            //For now we're going to ignore this
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        //Listen for bar order changes
        //database.child( "barorders/" ).addValueEventListener( barOrderListener );

        /*
        //Only use as an example
        Order order = new Order();
        order.items.add(new Drink(0));
        order.items.add(new Drink(1));
        instance.addBarOrder( order );

        Order order2 = new Order();
        order2.items.add(new Drink(2));
        order2.items.add(new Drink(3));
        order2.items.add(new Drink(4));
        instance.addBarOrder( order2 );
        */

        return instance;
    }

    //Adds a drink to the drink list in the database
    //Parameter is an array in the format { String name, String price }
    public void addToDrinkList( DrinkListItem drink ){

        //Add this drink to the drink list
        drinkList.add( drink );

        //Update the database with the new drink list
        //This will get increasingly expensive as the drink list grows but I'm banking on it not being like n = 100,000
        database.child( "drinklist/" ).setValue( drinkList );

    }

    //Gets a list of all orderable drinks from the database
    //Each is in the format { String name, String price }
    //This returns an automatically updated snapshot of the DrinkList database
    public ArrayList<DrinkListItem> getDrinkList(){
        return drinkList;
    }

    public void addBarOrder( Order order ){

        barOrders.add( order );

        database.child( "barorders/" ).setValue( barOrders );

    }

    public ArrayList<Order> getBarOrders(){ return barOrders;  }

}
