package com.revature.Pi2a1000Places.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pi2a1000Places.auth.LoginCreds;
import com.revature.Pi2a1000Places.util.exceptions.AuthenticationException;
import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;
import com.revature.Pi2a1000Places.util.interfaces.Authable;

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

        if (Authable.checkAuth(req, resp)) {
            try {
                System.out.println("Updating Customer");
                if (newUser.getUsername().equals(LoginCreds.getUsername())) {
                    System.out.println("passed auth");
                    newUser = customerServices.updateCustomer(newUser);
                    String payload = mapper.writeValueAsString(newUser);
                    resp.getWriter().write(payload);
                    resp.setStatus(200);
                } else {
                    throw new AuthenticationException("The username of the current user does not match the one to be updated");
                }
            }catch (AuthenticationException e){
                System.out.println("Not matching usernames");
                resp.setStatus(409);
                resp.getWriter().write(e.getMessage());
            }
        } else {
            try {
                System.out.println("Attempting to Create");
                resp.getWriter().write("\nAttempting to Create Account\n");
                customerServices.validateUserInput(newUser);
                resp.getWriter().write("This user has been created " + newUser);
                resp.setStatus(200);
            } catch (InvalidRequestException e) {
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
        try{
        if (Authable.checkAuth(req, resp)) {
            Customer customerToDelete = mapper.readValue(req.getInputStream(), Customer.class);
            Customer customer = new Customer();

            if (customerToDelete.getUsername().equals(LoginCreds.getUsername()) && customerToDelete.getPassword().equals(LoginCreds.getPassword())) {
                resp.getWriter().write( customerServices.deleteCustomer(customerToDelete));
                req.getSession().invalidate();
            }else{ resp.setStatus(409);
                throw new AuthenticationException("The username and password of the current user does not match the one to be deleted");
            }
        }
        }catch (AuthenticationException e){
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
    }

}
