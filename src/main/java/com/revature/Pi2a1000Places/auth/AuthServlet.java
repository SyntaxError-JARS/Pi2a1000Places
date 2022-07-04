package com.revature.Pi2a1000Places.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pi2a1000Places.customer.Customer;
import com.revature.Pi2a1000Places.customer.CustomerServices;
import com.revature.Pi2a1000Places.util.exceptions.AuthenticationException;
import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthServlet extends HttpServlet {

    private final CustomerServices customerServices;

    private final ObjectMapper mapper;

    public AuthServlet(CustomerServices customerServices, ObjectMapper mapper){
        this.customerServices = customerServices;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            LoginCreds loginCreds = mapper.readValue(req.getInputStream(), LoginCreds.class);

            Customer authCustomer = customerServices.authenticateCustomer(loginCreds.getUsername(), loginCreds.getPassword());



            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authCustomer", authCustomer);


            resp.getWriter().write("You have successfully logged in!");
        } catch (AuthenticationException | InvalidRequestException e){
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        } catch (Exception e){
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
    }

}
