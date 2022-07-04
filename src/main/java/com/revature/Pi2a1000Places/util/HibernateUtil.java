package com.revature.Pi2a1000Places.util;

import com.revature.Pi2a1000Places.creditcard.CreditCard;
import com.revature.Pi2a1000Places.customer.Customer;
import com.revature.Pi2a1000Places.menu.Menu;
import com.revature.Pi2a1000Places.order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration() {
                @Override
                public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
                    return new AppConfigurationEntry[0];
                }
            };
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

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }

        if (session == null) {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession() {
        session.close();
        session = null;

    }

                //See Lecture 5/27/2022 @21 minutes (added 6/4/22)- Azure App Configurations
                //Deploy via terminal (all 10 lines), then sign into acct

            String url = system.getenv(SQLAZURECONNSTR Pito1000DB);
            String username = system.getenv(name: "Dbuser")
            String password = system.getenv(password: "Dbpassword")

            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.url", url);
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.username", username);
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.password", password);
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.hibernate.show_sql", "true");
            configuration.setCurrentTenantIdentifierResolver("hibernate.connection.hibernate.hbm2ddl.auto", "update");



        hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
        hibernate.connection.driver_class=org.postgresql.Driver
        hibernate.connection.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=restaurant
        hibernate.connection.username=postgres
        hibernate.connection.password=
        hibernate.show_sql=true
        #Create once and update thereafter
        hibernate.hbm2ddl.auto=update