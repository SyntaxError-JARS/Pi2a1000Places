/*
 * Menu.java
 * 
 * Copyright 2022
 * 
 */
package com.revature.Pi2a1000Places.customer;


public class Menu {

private String iname;  			/* item_name primary key*/
private int cost;		  /* cost*/
private String protein;		 /* portein*/
private boolean substitue; 	  /* Is Substitutable */

public Menu( String iname, Integer cost, String protein, Boolean substitue){
	super ();
	this.iname = iname;
	this.cost = cost;
	this.protein = protein;
	this.substitue = substitue;
}

public Menu(){

}

    //Getters And Setters
    public String getIname(){return iname;}

    public void setIname(String lname){this.iname = iname;}
    
// Done
    public String getCost(){return cost;}

    public void setCost(int cost){this.cost = cost;}
// Done    
    
    public String getProtien(){return protien;}

    public void setProtien(String protien){this.protien = protien;}
// Done  


    public String getSubstitue(){return substitue;}

    public void setSubstitue(boolean substitue){this.substitue = substitue;}


    @Override
  /*  public String toString() {
        return "User Info{" +
                "First Name ='" + fname + '\'' +
                ", Last Name ='" + lname + '\'' +
                '}';
    }    Convert int to dollar notation   */
}