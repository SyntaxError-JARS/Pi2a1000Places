package com.revature.pi.models;

public class Menu {

    private String itemName;
    private String cost;
    private String pizza1;
    // private String pizza2;
    private String addTopping;

    public Menu(String itemName, String cost, String pizza1, String addTopping) {
        this.itemName = itemName;
        this.cost = cost;
        this.pizza1 = pizza1;
        //this.pizza2 = pizza2;
        this.addTopping = addTopping;

    }
}