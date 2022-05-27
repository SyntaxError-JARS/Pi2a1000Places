package com.revature.Pi2a1000Places.customer;

public class Customer {


    private String username;
    private String fname;
    private String lname;
    private String password;
    private String balance;

    public Customer( String username, String password, String fname,String lname, String balance){
        super();
        this.fname = fname;
        this.lname = lname;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public Customer(){

    }

    //Getters And Setters
    public String getFname(){return fname;}

    public void setFname(String fname){this.fname = fname;}

    public String getLname(){return lname;}

    public void setLname(String lname){this.lname = lname;}

    public String getBalance(){return balance;}

    public void setBalance(String balance){this.balance = balance;}

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}





    @Override
    public String toString() {
        return "User Info{" +
                "First Name ='" + fname + '\'' +
                ", Last Name ='" + lname + '\'' +
                '}';
    }

}


