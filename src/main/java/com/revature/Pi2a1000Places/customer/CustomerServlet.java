package com.revature.Pi2a1000Places.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        try {
            customerServices.validateUserInput(newUser);
        } catch (InvalidRequestException e) {
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        } finally {
            resp.getWriter().write("This user has been created " + newUser);
        }
    }
}
