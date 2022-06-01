package com.revature.Pi2a1000Places.util;

import com.revature.Pi2a1000Places.customer.Customer;
import com.revature.Pi2a1000Places.credit_card.CreditCard;
import com.revature.Pi2a1000Places.menu.Menu;
import com.revature.Pi2a1000Places.order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
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
            configuration.addAnnotatedClass(CreditCard.class);
            configuration.addAnnotatedClass(Menu.class);
            configuration.addAnnotatedClass(Order.class);

            // ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            try {
                sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy( serviceRegistry );
            }


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
