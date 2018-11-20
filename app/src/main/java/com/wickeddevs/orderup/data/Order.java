package com.wickeddevs.orderup.data;

import java.util.ArrayList;

public class Order {

    public int table;
    public int orderNumber;
    private int currentState = 0;               //Holds current index in state

                                                //Where in the process it is. (Order Placed, Cooked, Delivered, Done)
    private String[] state = {  "Created",      //Goes to kitchen/bar
                                "Cooked",       //Wait staff are notified to order to be picked up
                                "Delivered"};   //Order disappears from main screen and moves to history

    public ArrayList<Item> items = new ArrayList<>();


    public Order (){

    }

    public String getState(){                   //Gets the order's current state
        return state[currentState];
    }

    public String switchState(){                //Progresses to the next state
        currentState = (currentState + 1) % 3;
        return getState();
    }

    public String setState(int newState){       //If the position needs to be changed. Maybe no need to use.
        currentState = newState;
        return getState();
    }

    public void setState( String newState ){                     //Sets the state to a string

        for( int i = 0; i < state.length; i++ ){

            if( newState.equals( state[i] ) ){
                setState( i );

                return;
            }

        }

    }

    public void addItem(Item newItem){          //Adds an item to the order
        items.add(newItem);

    }

    public void sendOrder(){ //Sends the order to the server


    }


}
