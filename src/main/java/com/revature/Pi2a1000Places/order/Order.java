package com.revature.Pi2a1000Places.order;

import javax.persistence.*;

@Entity
@Table(name = "customer_order")
public class Order {

        @Id @GeneratedValue
        @Column(name = "id")
        private int id;
        @Column(name="menu_item")
        private String menuItem;
        @Column(name="comment")
        private String comment;
        @Column(name="is_Favorite")
        private boolean isFavorite;
        @Column(name="order_date")
        private String orderDate;
        @Column(name="customer_username")
        private String customerUsername;


        public Order( int id, String menuItem, String comment,boolean isFavorite, String orderDate, String customerUsername){
            super();
            this.id = id;
            this.menuItem = menuItem;
            this.comment = comment;
            this.isFavorite = isFavorite;
            this.orderDate = orderDate;
            this.customerUsername = customerUsername;
        }

        public Order(){

        }

        //Getters And Setters
        public int getId(){return id;}

        public void setId(int id){this.id = id;}

        public String getMenuItem(){return menuItem;}

        public void setMenuItem(String menuItem){this.menuItem = menuItem;}

        public String getComment(){return comment;}

        public void setComment(String comment){this.comment = comment;}

        public boolean getIsFavorite(){return isFavorite;}

        public void setIsFavorite(boolean isFavorite){this.isFavorite = isFavorite;}

        public String getOrderDate(){return orderDate;}

        public void setOrderDate(String orderDate){this.orderDate = orderDate;}

        public String getCustomerUsername(){return customerUsername;}

        public void setCustomerUsername(String customerUsername){this.customerUsername = customerUsername;}





        @Override
        public String toString() {
            return "User Info{" +
                    "Order ID ='" + id + '\'' +
                    ", Menu Item ='" + menuItem + '\'' +
                    ", Comment ='" + comment + '\'' +
                    ", Favorite ='" + isFavorite + '\'' +
                    ", Order Date ='" + orderDate + '\'' +
                    '}';
        }

    }






