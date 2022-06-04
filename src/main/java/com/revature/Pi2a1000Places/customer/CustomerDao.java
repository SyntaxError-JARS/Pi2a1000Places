package com.revature.Pi2a1000Places.customer;

import com.revature.Pi2a1000Places.util.ConnectionFactory;
import com.revature.Pi2a1000Places.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {

    public static Customer create(Customer newUser) {

        System.out.println("Here is the newUser as it enters our DAO layer: " + newUser); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "insert into customer (username, fname, lname, balance, password, is_admin) values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getFname());
            ps.setString(3, newUser.getLname());
            ps.setInt(4, Integer.parseInt(newUser.getBalance()));
            ps.setString(5, newUser.getPassword());
            ps.setBoolean(6, newUser.getIsAdmin());

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return newUser;
    }


    public Boolean pullUsernames(String username) {
        try {
            //System.out.println("Before Hibernate");
            Session session = HibernateUtil.getSession();
            //System.out.println("After Get Session");
            Transaction transaction = session.beginTransaction();

            // System.out.println("After Transaction");
            Customer customer = session.get(Customer.class,username);
            //System.out.println("After Session.get");
            transaction.commit();
            // System.out.println("After Transaction Commit");

            if(customer !=null){
                return true;
            }else return false;

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }



    public Customer authenticateCustomer(String username, String password) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from customer where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            Customer customer = new Customer();


            customer.setUsername(rs.getString("username"));
            customer.setFname(rs.getString("fname"));
            customer.setLname(rs.getString("lname"));
            customer.setPassword(rs.getString("password"));


            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public String deleteCustomer(String username) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "delete from \"order\" where customer_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);


            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "delete from customer where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);


            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        String deletedAccount;
        return deletedAccount = ("Account of " + username + " has been deleted \n");
    }

    public Customer updateCustomer(Customer customerToUpdate){
            String username = customerToUpdate.getUsername();
            String password = customerToUpdate.getPassword();

        try {
            Session session = HibernateUtil.getSession();

            Transaction transaction = session.beginTransaction();
            session.update(username, customerToUpdate);
            transaction.commit();

            session.beginTransaction();
            Customer customer = session.get(Customer.class,username);
            transaction.commit();

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
        return customerToUpdate;
    }

    public Boolean checkAdmin(Customer customerToUpdate) {
        try {
            String username = customerToUpdate.getUsername();

            Session session = HibernateUtil.getSession();

            Transaction transaction = session.beginTransaction();

            Customer customer = session.get(Customer.class,username);

            transaction.commit();


            if(customer.getIsAdmin() == true){
                return true;
            }else return false;

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }


    }



