package com.wickeddevs.orderup.data;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wickeddevs.orderup.data.ListObjects.DrinkListItem;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

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

        //Set up data listeners

        //Drink list listener
        ValueEventListener drinkListListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Start creating a new drinklist
                drinkList = new ArrayList<DrinkListItem>();

                for( DataSnapshot child : dataSnapshot.getChildren() ){

                    HashMap itemHashmap = ( (HashMap) child.getValue() );

                    String itemName = (String) itemHashmap.get( "name" );
                    double itemPrice = (double) itemHashmap.get( "price" );

                    //Make a new DrinkListItem from this child's insane hashmap
                    DrinkListItem item = new DrinkListItem( itemName, itemPrice );

                    //Add this item to the new drinklist
                    drinkList.add( item );

                }
            }

            //For now we're going to ignore this
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        database.child( "drinklist" ).addValueEventListener( drinkListListener );

        //Drink list listener
        ValueEventListener barOrderListener = new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                System.out.println( " wew " );

                //Start creating a new order list
                barOrders = new ArrayList<Order>();

                for( DataSnapshot child : dataSnapshot.getChildren() ){

                    HashMap orderHashmap = ( (HashMap) child.getValue() );

                    //Get the order number
                    int orderNumber =  Math.toIntExact( (long) orderHashmap.get( "orderNumber" ) );

                    //Get the state
                    String state = (String) orderHashmap.get( "state" );

                    //Get the table number
                    int tableNumber =  Math.toIntExact( (long) orderHashmap.get( "table" ) );

                    //Get the order's items
                    ArrayList orderItems = (ArrayList) orderHashmap.get( "items" );

                    //Recreate the order
                    Order order = new Order();
                    order.setState( state );
                    order.table = tableNumber;
                    order.orderNumber = orderNumber;

                    for( Object itemObject : orderItems ){

                        //Convert the item
                        HashMap itemHashmap = (HashMap) itemObject;

                        //Get the item name
                        String itemName = (String) itemHashmap.get( "name" );

                        //Get the item ID
                        int itemID = Math.toIntExact( (long) itemHashmap.get( "id" ) );

                        //Get the item's price
                        double itemPrice = (double) itemHashmap.get( "price" );

                        //Create a new item
                        Item item = new Drink( itemID, itemName, itemPrice );

                        //Add the item to the order
                        order.addItem( item );

                    }

                    //Add the order to the order list
                    barOrders.add( order );

                }

            }

            //For now we're going to ignore this
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        database.child( "barorders" ).addValueEventListener( barOrderListener );

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
