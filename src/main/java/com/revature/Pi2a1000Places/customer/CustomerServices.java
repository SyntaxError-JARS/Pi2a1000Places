package com.revature.Pi2a1000Places.customer;

import com.revature.Pi2a1000Places.util.exceptions.AuthenticationException;
import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;

public class CustomerServices {

    private CustomerDao customerDao = new CustomerDao();
    private Customer customer = new Customer();

    public CustomerServices(CustomerDao customerDao){this.customerDao = customerDao;}

    public CustomerServices() {

    }


    //TODO:Exceptions to yell at the user
    public boolean validateUserInput(Customer newUser) throws InvalidRequestException {
        System.out.println("Validating User: " + newUser);
        if(newUser == null) return false;
        if(newUser.getFname() == null || newUser.getFname().trim().equals("")){
            throw new InvalidRequestException("First Name cannot be blank");}
        if(newUser.getLname() == null || newUser.getLname().trim().equals("")){
            throw new InvalidRequestException("Last Name cannot be blank");}
        if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")){
            throw new InvalidRequestException("Username cannot be blank");}
        if(newUser.getPassword() == null || newUser.getPassword().trim().equals("")){
            throw new InvalidRequestException("Password cannot be blank");}
        System.out.println("The User Has been Validated");
        if (verifyNewUsername(newUser.getUsername()) == true) {
            System.out.println("It worked dingus");
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

        return authenticatedCustomer;
    }

    public String deleteCustomer(Customer customerToDelete){
        String fname = customerToDelete.getFname();
        String lname = customerToDelete.getLname();
        String username = customerToDelete.getUsername();
        String password = customerToDelete.getPassword();
        String deleteStatement = customerDao.deleteCustomer(username);


        return deleteStatement ;
    }

    public Customer updateCustomer(Customer customerToUpdate){
        String customerName = customerToUpdate.getModName();
        System.out.println("modName: " + modName);
        String creatorName = customerToUpdate.getCreatorName();
        System.out.println("creatorName: "+ creatorName);
        String id = modToUpdate.getId();
        System.out.println("Id: "+ id);
        if(!verifyCreatorName(creatorName)){throw new InvalidRequestException("This creator doesn't exist");}
        else if(!verifyId(id)){throw new InvalidRequestException("This id doesn't exist");}
        else if(verifyModName(modName)){
            throw new InvalidRequestException("This mod already exists " + modDao.findByModName(modName));
        }
        else{return modDao.updateMod(modName,creatorName,id);}

    }


}
