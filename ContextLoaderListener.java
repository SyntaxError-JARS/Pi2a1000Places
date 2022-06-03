package com.revature.Pi2a1000Places.util.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pi2a1000Places.auth.AuthServlet;
import com.revature.Pi2a1000Places.customer.CustomerDao;
import com.revature.Pi2a1000Places.customer.CustomerServices;
import com.revature.Pi2a1000Places.customer.CustomerServlet;
import com.revature.Pi2a1000Places.order.OrderServices;
import com.revature.Pi2a1000Places.order.OrderServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDao customerDao = new CustomerDao();
        CustomerServices customerServices = new CustomerServices();
        OrderServices orderServices = new OrderServices();

        AuthServlet authServlet = new AuthServlet(customerServices, mapper);
        CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);
        OrderServlet orderServlet = new OrderServlet(orderServices, mapper);


        ServletContext context = sce.getServletContext();
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("CustomerServlet", customerServlet).addMapping("/customers/*");
        context.addServlet("OrderServlet", orderServlet ).addMapping("/orders/*");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}

