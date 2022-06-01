/*
 * MenuServices.java
 * 
 * Copyright 2022 Rodney
 * 
 * 
 */


package com.revature.Pi2a1000Places.customer;

import com.revature.Pi2a1000Places.util.exceptions.AuthenticationException;
import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;

public class CustomerServices {

    private MenuDao MenuDao = new MenuDao();
    private Menu menu = new menu();

    public MenuServices(MenuDao menuDao){this.menuDao = menuDao;}

    public MenuServices() {

    }


    //TODO:Exceptions to yell at the iname
    public boolean validateMenuInput(Menu newMenu) throws InvalidRequestException {
        System.out.println("Validating Menu Item: " + newiname);
        if(newIname == null) return false;
       
  
        if(newMenu.getIname() == null){
            throw new InvalidRequestException("Item Name cannot be blank");}
            
            
        if(newMenu.getProtien() == null){			
            throw new InvalidRequestException("Protien cannot be blank");}
            
        if(newMenu.getCost() == null){		
            throw new InvalidRequestException("Cost cannot be blank");}
            
        if(newUser.getPassword() == null){
            throw new InvalidRequestException("Substitute cannot be blank");}
            
        System.out.println("The Menu has been validated");
        if (verifyNewMenu(newMenu.getMenu()) == true) {
			
			
            throw new InvalidRequestException("That menu item has already been used");
        }else{
            createNewMenu(newMenu);
            return true;
        }
    }
/*
    public boolean verifyNewMenu(String username){
        return customerDao.pullMenu(username);
    }
*/

    public Menu createNewMenu(Customer newMenu){
        System.out.println("New menu item being created " + newMenu);

        return CustomerDao.create(newUser);
    }


    //Tells the authServlet that everything is good
    public Customer authenticateCustomer(String username, String password){

        if(password == null || password.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
        }

        Customer authenticatedCustomer = customerDao.authenticateCustomer(username, password);

        if (authenticatedCustomer == null){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return customer;
    }

}
