package com.revature.Pi2a1000Places.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pi2a1000Places.auth.LoginCreds;
import com.revature.Pi2a1000Places.util.exceptions.AuthenticationException;
import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {

    private final CustomerServices customerServices;
    private final ObjectMapper mapper;

    public CustomerServlet(CustomerServices customerServices, ObjectMapper mapper) {
        this.customerServices = customerServices;
        this.mapper = mapper;
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        Customer newUser = mapper.readValue(req.getInputStream(), Customer.class);

        if(!Authable.checkAuth(req, resp)){
        try {
            resp.getWriter().write("\nAttempting to Create Account\n");
            customerServices.validateUserInput(newUser);
            resp.getWriter().write("This user has been created " + newUser);
        } catch (InvalidRequestException e) {
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
        } else if (Authable.checkAuth(req, resp)) {
            try {
                if (newUser.getUsername().equals(LoginCreds.getUsername()) && newUser.getPassword().equals(LoginCreds.getPassword())) {
                    newUser = customerServices.updateCustomer(newUser);
                    String payload = mapper.writeValueAsString(newUser);
                    resp.getWriter().write(payload);
                } else {
                    throw new AuthenticationException("The username and password of the current user does not match the one to be deleted");
                }
            }catch (AuthenticationException e){
                resp.setStatus(409);
                resp.getWriter().write(e.getMessage());
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if (Authable.checkAuth(req, resp)) {
            Customer customerToDelete = mapper.readValue(req.getInputStream(), Customer.class);
            Customer customer = new Customer();

            if (customerToDelete.getUsername().equals(LoginCreds.getUsername()) && customerToDelete.getPassword().equals(LoginCreds.getPassword())) {
                resp.getWriter().write( customerServices.deleteCustomer(customerToDelete));
            }else{throw new AuthenticationException("The username and password of the current user does not match the one to be deleted");
            }
        }
    }

}
