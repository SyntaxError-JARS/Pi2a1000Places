package com.revature.Pi2a1000Places.order;

import com.revature.Pi2a1000Places.util.exceptions.InvalidRequestException;

import java.util.Calendar;
import java.util.Random;

public class OrderServices {
    
    OrderDao orderDao = new OrderDao();
    private final Calendar calendar = Calendar.getInstance();
    
    public Order createOrder(Order orderToCreate) {

        System.out.println("Adding order");
        Random random = new Random();
        int id = Math.abs(random.nextInt());
        int date = calendar.get(Calendar.DAY_OF_MONTH);

        String menuItem = orderToCreate.getMenuItem();
        String username = orderToCreate.getCustomerUsername();

        if(username == null){throw new InvalidRequestException("Username cannot be null");
        }else if(menuItem == null) {throw new InvalidRequestException("Menu Item cannot be null");
        }else {
            return orderDao.createOrder(username, menuItem, id, date);
        }

    }
}
