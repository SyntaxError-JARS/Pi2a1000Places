package com.revature.Pi2a1000Places.menu;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

@Id
    private String menuItem;

    private int cost;

    private String protein;

    private String isSubstitutable;

    public Menu(String menuItem, int cost, String protein, String isSubstitutable) {
        super();
        this.menuItem = menuItem;
        this.cost = cost;
        this.protein = protein;
        this.isSubstitutable = isSubstitutable;

    }
    public Menu() {

    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSubstitutable() {
        return isSubstitutable;
    }

    public void setSubstitutable(String substitutable) {
        isSubstitutable = substitutable;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuItem='" + menuItem + '\'' +
                ", cost=" + cost +
                ", protein='" + protein + '\'' +
                ", isSubstitutable=" + isSubstitutable +
                '}';
    }
}

