//package com.revature.Pi2a1000Places.creditcard;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.Pi2a1000Places.auth.LoginCreds;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CreditCardServlet extends HttpServlet{
//    Private final ObjectMapper mapper;
//    private final CreditCardDao creditCardDao;
//
//    public CreditCardServlet(ObjectMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doOptions(req, resp);
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//
//    }
//
//    //CREATE
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
////        addHeads(req, resp);
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//        CreditCard firstResult = CreditCardDao.createCC(pass.getCcNumber(), pass.getCcName(), pass.getCvv(), pass.getExpDate(), pass.getZip(), pass.getLimits(), pass.getCustomerUsername());
//        CreditCard theObject = CreditCardDao.followUpCreateCreditCard(pass.getCcNumber());
//
//        String payload = mapper.writeValueAsString(theObject);
//
//        resp.getWriter().write("Credit Card Added \n");
//        resp.getWriter().write(payload);
//        resp.setStatus(201);
//    }
//
//  //  UPDATE
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//
//        CreditCard firstResult = creditCardDao.update(pass.getTableSelection(), pass.getNewCellName(), pass.getCcNumber());
//        CreditCard theObject = creditCardDao.update(pass.getCcNumber());
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
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");        CreditCardDto pass = mapper.readValue(req.getInputStream(), CreditCardDto.class);
//
//        boolean deleteTrue = creditCardDao.delete(pass.getCcNumber());
//
//        String payload = mapper.writeValueAsString(deleteTrue);
//
//        resp.getWriter().write("Credit Card deleted \n");
//        resp.getWriter().write(payload);
//        resp.setStatus(201);
//    }
//
//
//}
