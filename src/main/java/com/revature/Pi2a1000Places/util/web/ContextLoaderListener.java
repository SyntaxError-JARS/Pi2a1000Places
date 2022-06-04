package com.revature.Pi2a1000Places.util.web;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.Pi2a1000Places.auth.AuthServlet;
import com.revature.Pi2a1000Places.creditcard.CreditCardServices;
import com.revature.Pi2a1000Places.creditcard.CreditCardServlet;
import com.revature.Pi2a1000Places.creditcard.CreditCardDao;
//import com.revature.Pi2a1000Places.customer.Customer;
//import com.revature.Pi2a1000Places.customer.CustomerDao;
//import com.revature.Pi2a1000Places.customer.CustomerServices;
//import com.revature.Pi2a1000Places.customer.CustomerServlet;
import com.revature.Pi2a1000Places.order.OrderServices;
import com.revature.Pi2a1000Places.order.OrderServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    private ObjectMapper creditCardDao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();
//        CustomerDao customerDao = new CustomerDao();
//        CustomerServices customerServices = new CustomerServices();
        OrderServices orderServices = new OrderServices();
        CreditCardDao creditCardDao = new CreditCardDao();

//        AuthServlet authServlet = new AuthServlet(customerServices, mapper);
//        CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);
        OrderServlet orderServlet = new OrderServlet(orderServices, mapper);
        CreditCardServlet creditCardServlet = new CreditCardServlet(creditCardDao);

        ServletContext context = sce.getServletContext();
//        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
//        context.addServlet("CustomerServlet", customerServlet).addMapping("/customers/*");
        context.addServlet("OrderServlet", orderServlet ).addMapping("/orders/*");
        context.addServlet("CreditCardServlet", creditCardServlet).addMapping("/creditCard/*");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}

