package com.revature.Pi2a1000Places.order;

import com.revature.Pi2a1000Places.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class OrderDao {


    public Order createOrder(String username, String menuItem, int id, int date) {


        System.out.println("Persisting Order");

        Order order = new Order();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "insert into \"order\" values (?, ?, null, default, ?, ? );";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2, menuItem);
            ps.setInt(3, date);
            ps.setString(4, username);

            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "select * from \"order\" where customer_username = ? and menu_item = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, menuItem);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                order.setId(rs.getString("id"));
                order.setMenuItem(rs.getString("menu_item"));
                order.setCustomerUsername(rs.getString("customer_username"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println("Order Persisted");
        return order;
    }
    
    
}
