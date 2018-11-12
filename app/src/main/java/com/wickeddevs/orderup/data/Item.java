package com.wickeddevs.orderup.data;

public abstract class Item {

    protected int id;
    private String modifications;

    public String getModifications() {
        return modifications;
    }
    public void setModifications(String modifications) {
        this.modifications = modifications;
    }

    public abstract String getName();

    public abstract double getPrice();

    public abstract void addToOrder();
}
