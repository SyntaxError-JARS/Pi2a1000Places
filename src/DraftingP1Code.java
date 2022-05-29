package com.revature.DraftingP1Code.util;  // change

import java.io.IOException;		//	To catch input/output Exceptions
import java.sql.Connection;		//  A unique session to SQL Server data source
import java.sql.DriverManager;	//  Interface between users and drivers
import java.sql.SQLException;	//	To catch SQL method handle of Exception


public class Restaurant1 {			// Start of class code
	
    private static final Restaurant1 connectionFactory = new Restaurant1();
    private Properties prop = new Properties();

    private Restaurant1(){
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            prop.load(loader.getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        } }							// end of private type method

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } }									// ends the static type and catch

    public static Restaurant1 getInstance(){
        return connectionFactory;	}		// return value to calling function								
  
    public Connection getConnection() {	 // Provide access to datasource
        Connection conn;

        try {							// An attempt
            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);		// Treat response as this
        }
        return conn;				// Give back this value
    }
}							// end of pubic class code
