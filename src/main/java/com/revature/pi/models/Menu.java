package com.revature.pi.models;

public class Menu {

    private String itemName;
    private String cost;
    private String pizza1;
    // private String pizza2;
    private String addTopping;
    //is_substitutable;

    public Menu(String itemName, String cost, String pizza1, String addTopping) {
        this.itemName = itemName;
        this.cost = cost;
        this.pizza1 = pizza1;
        //this.pizza2 = pizza2;
        this.addTopping = addTopping;
        //is_substitutable;

    }

    public String getItemName() {
        return itemName;
    }
    public String getCost() {
        return cost;
    }

    public String getPizza1() {
        return pizza1;
    }

    public String getAddTopping() {
        return addTopping;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setPizza1(String pizza1) {
        this.pizza1 = pizza1;
    }

    public void setAddTopping(String addTopping) {
        this.addTopping = addTopping;
    }

        }
