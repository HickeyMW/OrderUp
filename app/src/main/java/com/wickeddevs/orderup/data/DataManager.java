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

    private static DatabaseReference database = FirebaseDatabase.getInstance().getReference();;

    //Our local copy of the drink list
    private static ArrayList<DrinkListItem> drinkList;

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

        //When instantiated, we also want to set up our data listeners
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
        database.child( "drinklist/" ).addValueEventListener( drinkListListener );

        //For testing

        addToDrinkList( new DrinkListItem( "Margarita", 4.99 ) );
        addToDrinkList( new DrinkListItem( "White Russian", 4.99 ) );
        addToDrinkList( new DrinkListItem( "Sex on the Beach", 4.99 ) );
        addToDrinkList( new DrinkListItem( "Blowjob", 4.99 ) );
        addToDrinkList( new DrinkListItem( "Mojito", 4.99 ) );
        addToDrinkList( new DrinkListItem( "B-52", 3.49 ) );
        addToDrinkList( new DrinkListItem( "Bud Light", 3.49 ) );
        addToDrinkList( new DrinkListItem( "Miller Light", 3.49 ) );
        addToDrinkList( new DrinkListItem( "Coors Light", 3.49 ) );
        addToDrinkList( new DrinkListItem( "Hamms", 3.49 ) );
        addToDrinkList( new DrinkListItem( "Corona Extra", 4.49 ) );
        addToDrinkList( new DrinkListItem( "Landshark", 4.49 ) );
        addToDrinkList( new DrinkListItem( "Chardonnay", 4.49 ) );
        addToDrinkList( new DrinkListItem( "Cabernet", 4.49 ) );
        addToDrinkList( new DrinkListItem( "Moscato", 4.49 ) );
        addToDrinkList( new DrinkListItem( "Champagne", 5.49 ) );
        addToDrinkList( new DrinkListItem( "Riesling", 5.49 ) );
        addToDrinkList( new DrinkListItem( "PinotNoir", 5.49 ) );
        addToDrinkList( new DrinkListItem( "Merlot", 5.49 ) );
        addToDrinkList( new DrinkListItem( "PinotGrigio", 5.49 ) );
        addToDrinkList( new DrinkListItem( "Sauvignon Blanc", 5.49 ) );

        return instance;
    }

    //Adds a drink to the drink list in the database
    //Parameter is an array in the format { String name, String price }
    public static void addToDrinkList( DrinkListItem drink ){

        //Add this drink to the drink list
        drinkList.add( drink );

        //Update the database with the new drink list
        //This will get increasingly expensive as the drink list grows but I'm banking on it not being like n = 100,000
        database.child( "drinklist/" ).setValue( drinkList );

    }

    //Gets a list of all orderable drinks from the database
    //Each is in the format { String name, String price }
    //This returns an automatically updated snapshot of the DrinkList database
    public static ArrayList<DrinkListItem> getDrinkList(){
        return drinkList;
    }

}
