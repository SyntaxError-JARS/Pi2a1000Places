package com.revature.Pi2a1000Places.util.interfaces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Authable {

    static boolean checkAuth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authCustomer") == null){
            resp.getWriter().write("Unauthorized request - not log in as registered user");
            resp.setStatus(401); // Unauthorized
            return false;
        }
        return true;
    }

    void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
