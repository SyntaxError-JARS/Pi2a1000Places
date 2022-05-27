package com.revature.Pi2a1000Places.auth;

public class LoginCreds {

    private static String username;
    private static String password;

    // JACKSON REQUIRES A NO ARG CONSTRUCTOR

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
