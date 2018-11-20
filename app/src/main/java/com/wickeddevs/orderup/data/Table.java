package com.wickeddevs.orderup.data;

public class Table {

    public int tableNumber;
    public int appetizerStatus;
    public int drinkStatus;
    public int foodStatus;

    public final int NEED_TO_ORDER = 0;
    public final int ORDER_PLACED = 1;
    public final int ORDER_READY = 2;
    public final int ORDER_DELIVERED = 3;

}
