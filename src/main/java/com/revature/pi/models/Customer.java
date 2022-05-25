package com.revature.pi.models;

public class Customer {
     {

    }
    //Customer-facing, experience API Layer
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String balance;
    //private String is_admin;
    //Record as a String, convert to a Boolean later? Parse it? Lookup when and why?

    public Customer(String userName, String firstName, String lastName, String password, String balance) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.balance = balance;
        //this.is_admin= false;
    }
    //Getters & setters used for fetching and updating variable value.
    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getBalance() {
        return balance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(String balance) {
        this.balance = balance;
        {

        }
//        public String toFileString () {
//            StringBuilder stringBuilder = new StringBuilder()
//                    .append(userName).append(",")
//                    .append(firstName).append(",")
//                    .append(lastName).append(",")
//                    .append(password).append(",")
//                    .append(balance).append(",");
//
//            return stringBuilder.toString();
//        }
//        public String () {
//            return "Customer{" +
//                    ",email='" + userName + '\' +
//            "firstName='" + firstName '\' +
//            "lastName='" + lastName '\' +
//            "password='" + password '\' +
//            "balance='" + balance '\' +
//            '}';
        }

    }