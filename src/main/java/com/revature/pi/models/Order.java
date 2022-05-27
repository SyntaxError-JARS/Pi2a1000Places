package com.revature.pi.models;

public class Order {

    private String id;
    private String menuItem;
    private String comment;
    //private String isFavorite;
    private String orderDate;
    private String userName;

    public Order(String id, String menuItem, String comment, String orderDate, String userName) {
        this.id = id;
        this.menuItem = menuItem;
        this.comment = comment;
        //this.isFavorite;
        this.orderDate = orderDate;
        this.userName = userName;

    }

    public String getId() {
        return id;
    }
    public String getMenuItem() {
        return menuItem;
    }

    public String getComment() {
        return comment;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public String getUserName() {
        return userName;
    }
    public void setId(String itemId) {
        this.id = id;
    }
    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
