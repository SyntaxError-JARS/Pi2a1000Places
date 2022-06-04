package com.revature.Pi2a1000Places.order;

import com.revature.Pi2a1000Places.auth.LoginCreds;
import com.revature.Pi2a1000Places.customer.Customer;
import com.revature.Pi2a1000Places.util.ConnectionFactory;
import com.revature.Pi2a1000Places.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderDao {


    public Order createOrder(Order orderToCreate) {
        System.out.println("Persisting Order");
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(orderToCreate);
            transaction.commit();

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
        return orderToCreate;
    }

    public List<Order> orderByDate(Order orderToCreate, String date) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();

           Query query = session.createQuery("from Order where orderDate= :date and customerUsername= :username");
            query.setParameter("date", date);
            query.setParameter("username", LoginCreds.getUsername());

            List<Order> orders = (List<Order>) query.getResultList();


            transaction.commit();
            return orders;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }


    }
    
    

