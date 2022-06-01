/*
 * Menu.java
 * 
 * Copyright 2022 vow <>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
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
