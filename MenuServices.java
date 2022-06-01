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


    //TODO:Exceptions to yell at the imenu
    public boolean validateMenuInput(Menu newMenu) throws InvalidRequestException {
        System.out.println("Validating Menu Item: " + newiname);
        if(newIname == null) return false;
       
       
        if(newMenu.getIname() == null || newMenu.getIname().trim().equals("")){
			
			
            throw new InvalidRequestException("First Name cannot be blank");}
            
        if(newUser.getLname() == null || newUser.getLname().trim().equals("")){
			
			
            throw new InvalidRequestException("Last Name cannot be blank");}
            
        if(newIname.getUsername() == null || newUser.getUsername().trim().equals("")){
			
			
            throw new InvalidRequestException("Username cannot be blank");}
            
        if(newUser.getPassword() == null || newUser.getPassword().trim().equals("")){
			
			
            throw new InvalidRequestException("Password cannot be blank");}
            
        System.out.println("The User Has been Validated");
        if (verifyNewUsername(newUser.getUsername()) == true) {
			
			
            throw new InvalidRequestException("That username has already been taken");
        }else{
            createNewUser(newUser);
            return true;
        }
    }

    public boolean verifyNewUsername(String username){
        return customerDao.pullUsernames(username);
    }


    public Customer createNewUser(Customer newUser){
        System.out.println("New user being created " + newUser);

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
