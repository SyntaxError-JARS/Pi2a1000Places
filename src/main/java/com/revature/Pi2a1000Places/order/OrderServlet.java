package com.revature.Pi2a1000Places.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pi2a1000Places.auth.LoginCreds;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.Pi2a1000Places.util.interfaces.Authable.checkAuth;

public class OrderServlet extends HttpServlet {

    private final OrderServices orderServices;
    private final ObjectMapper mapper;



    public OrderServlet(OrderServices orderServices, ObjectMapper mapper) {
        this.orderServices = orderServices;
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

       if (checkAuth(req, resp)) {
        System.out.println("Creating Order");
            Order orderToCreate = mapper.readValue(req.getInputStream(), Order.class);
            Order order = new Order();
        System.out.println(LoginCreds.getUsername());
            if (orderToCreate.getCustomerUsername().equals(LoginCreds.getUsername())) {
                //creating
                order = orderServices.createOrder(orderToCreate);
                String payload = mapper.writeValueAsString(order);
                resp.getWriter().write(payload);
            }


        }
    }




}
