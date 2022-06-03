//package com.revature.Pi2a1000Places.customer;
//
//import com.revature.Pi2a1000Places.util.ConnectionFactory;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CustomerDao {
//
//    public static Customer create(Customer newUser) {
//
//        System.out.println("Here is the newUser as it enters our DAO layer: " + newUser); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//
//            String sql = "insert into customer (username, fname, lname, password) values (?, ?, ?, ?)";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//
//            ps.setString(1, newUser.getUsername());
//            ps.setString(2, newUser.getFname());
//            ps.setString(3, newUser.getLname());
//            ps.setString(4, newUser.getPassword());
//
//            int checkInsert = ps.executeUpdate();
//
//            if (checkInsert == 0) {
//                throw new RuntimeException();
//            }
//
//        } catch (SQLException | RuntimeException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return newUser;
//    }
//
//
//    public Boolean pullUsernames(String username) {
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//            String sql = "select username from customer where username = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (!rs.isBeforeFirst()) {
//                return false;
//            }
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//
//
//    public Customer authenticateCustomer(String username, String password) {
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//            String sql = "select * from customer where username = ? and password = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (!rs.next()) {
//                return null;
//            }
//
//            Customer customer = new Customer();
//
//
//            customer.setUsername(rs.getString("username"));
//            customer.setFname(rs.getString("fname"));
//            customer.setLname(rs.getString("lname"));
//            customer.setPassword(rs.getString("password"));
//
//
//            return customer;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//
//    }
//
//    public String deleteCustomer(String username) {
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//            String sql = "delete from \"order\" where customer_username = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//
//
//            int rs = ps.executeUpdate();
//            System.out.println(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//            String sql = "delete from customer where username = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//
//
//            int rs = ps.executeUpdate();
//            System.out.println(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        String deletedAccount;
//        return deletedAccount = ("Account of " + username + " has been deleted \n");
//    }
//
//
//}
