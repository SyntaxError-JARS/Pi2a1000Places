package com.revature.Pi2a1000Places.util;

import com.revature.Pi2a1000Places.customer.Customer;
import com.revature.Pi2a1000Places.creditcard.CreditCard;
import com.revature.Pi2a1000Places.menu.Menu;
import com.revature.Pi2a1000Places.order.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties props = new Properties();

        
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("hibernate.properties"));

            configuration.setProperties(props);

            configuration.addAnnotatedClass(Customer.class);


            //configuration.addAnnotatedClass(CreditCard.class);
            //configuration.addAnnotatedClass(Menu.class);
            configuration.addAnnotatedClass(Order.class);


            // ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);



        }

        if(session == null) {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession() {
        session.close();
        session = null;

    }
}

//        hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
//        hibernate.connection.driver_class=org.postgresql.Driver
//        hibernate.connection.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=restaurant
//        hibernate.connection.username=postgres
//        hibernate.connection.password=
//        hibernate.show_sql=true
//        #Create once and update thereafter

