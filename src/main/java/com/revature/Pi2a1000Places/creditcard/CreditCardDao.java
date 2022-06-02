package com.revature.Pi2a1000Places.creditcard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class CreditCardDao {

    public static void main(String[] args)
    {

     //Create creditCard
 CreditCard creditcard = new CreditCard();
    creditcard.setCreditCardNumber("7878");
    creditcard.setCreditCardName("Test");
    creditcard.setCreditCardCvv("888");
    creditcard.setCreditCardExpDate("12/12/28");
    creditcard.setCreditCardZip("64646");
    creditcard.setCreditCardLimit("55000");
    creditcard.setCreditCardUserName("Name");

 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 Session session = sessionFactory.openSession();
    session.beginTransaction();

        session.save(CreditCard);
        System.out.println("CC Added");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
}
    //Update creditCard

    {

        SessionFactory sessionFactory = com.revature.Pi2a1000Places.util.ConnectionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        com.revature.Pi2a1000Places.creditcard.CreditCard creditCard = com.revature.Pi2a1000Places.creditcard.CreditCardDao();
        creditCard.setCcName() ("Test");
        System.out.println("CC Updated");
        session.getTransaction().commit();
        sessionFactory.close();
    }

    //Delete creditCard
//    SessionFactory sessionFactory = com.revature.Pi2a1000Places.util.ConnectionFactory();
//    Session session = sessionFactory.openSession();
//    session.beginTransaction();
//    session.delete(creditCard);
//    System.out.println("CC Deleted");
//    session.getTransaction().commit();
//    sessionFactory.close();
}

    // MVP a. Create - ADD Card
//    public CreditCard addCC(String ccNumber, String ccName, String cvv, String expDate, String zip, String limits, String customerUsername) {
//        try(Connection conn = ConnectionFactory.getInstance().getConnection();){
//            String sql = "insert into credit_card values (?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setString(1,ccNumber);
//            ps.setString(2, ccName);
//            ps.setString(3, cvv);
//            ps.setString(4, expDate);
//            ps.setString(5, zip);
//            ps.setString(6, limits);
//            ps.setString(7, customerUsername);
//
//            int checkInsert = ps.executeUpdate();
//
//            if (checkInsert == 0){
//                throw new RuntimeException();
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }
//
//
//    // MVP b. Update - UPDATE Card
//    public static CreditCard update(Object updatedObject) {
//        return null;
//    }
//
//    //// MVP c. Delete - DELETE Card
//    public boolean deleteByCCNumber(String ccNumber) {
//        Connection conn = ConnectionFactory.getInstance().getConnection();
//        {
//            String sql = "delete from credit_card where cc_number = ?";
//
//            try {
//                PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setString(1, ccNumber);
//
//                int checkInsert = ps.executeUpdate();
//
//                if (checkInsert == 0) {
//                    throw new RuntimeException();
//                }
//
//                return true;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return false;
//    }
//}
//
////    d.   Pay off your balance with your credit card  > Update (to the limit)
////4.5 (for credit card update and update limit see do get in trainer servlet )
//}
