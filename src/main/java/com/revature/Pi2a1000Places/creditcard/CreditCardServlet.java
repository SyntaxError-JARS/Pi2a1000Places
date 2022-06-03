//package com.revature.Pi2a1000Places.creditcard;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CreditCardServlet extends HttpServlet {
//    private final ObjectMapper mapper;
//    private final CreditCardServices creditCardServices;
//
//    public CreditCardServlet(ObjectMapper mapper, CreditCardServices creditCardServices) {
//        this.mapper = mapper;
//        this.creditCardServices = creditCardServices;
//    }
//
//
//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doOptions(req, resp);
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//
//    }
//
//    //CREATE- Allows servlet to handle a POST request
//    // ** Sending information to the server like HTML form data
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
////        addHeads(req, resp);
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//
//
//        resp.getWriter().write("Credit Card Added \n");
////        resp.getWriter().write(payload);
//        resp.setStatus(201);
//    }
//
//    //  UPDATE
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//
//        CreditCard theObject = creditCardServices.update(pass.getCreditCard());
//
//        String payload = mapper.writeValueAsString(theObject);
//
//        resp.getWriter().write("Credit Card Updated \n");
//        resp.getWriter().write(payload);
//        resp.setStatus(201);
//    }
//
//    //DELETE
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//        boolean deleteTrue = creditCardServices.delete();
//
//        String payload = mapper.writeValueAsString(deleteTrue);
//
//        resp.getWriter().write("Credit Card deleted \n");
//        resp.getWriter().write(payload);
//        resp.setStatus(201);
//    }
//}
