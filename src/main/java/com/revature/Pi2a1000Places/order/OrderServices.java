package com.revature.Pi2a1000Places.order;

import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class OrderServices {
    
    OrderDao orderDao = new OrderDao();
    private final Calendar calendar = Calendar.getInstance();
    
    public Order createOrder(Order orderToCreate) {

        System.out.println("Adding order");
        Random random = new Random();
        int id = Math.abs(random.nextInt());

        int month = (calendar.get(calendar.MONTH))+1;
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int year = calendar.get(calendar.YEAR);
        String date = month + "/" + day + "/" + year;

        orderToCreate.setOrderDate(date);
        orderToCreate.setId(id);

        String menuItem = orderToCreate.getMenuItem();
        String username = orderToCreate.getCustomerUsername();

        if(username == null){throw new InvalidRequestException("Username cannot be null");
        }else if(menuItem == null) {throw new InvalidRequestException("Menu Item cannot be null");
        }else {
            return orderDao.createOrder(orderToCreate);
        }

    }

    public List<Order> getOrderByDate(Order orderToCreate, String date){

        return orderDao.orderByDate(orderToCreate, date);
    }

}
