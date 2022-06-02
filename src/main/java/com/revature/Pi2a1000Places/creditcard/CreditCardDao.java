package com.revature.Pi2a1000Places.creditcard;

import com.revature.Pi2a1000Places.creditcard.CreditCardServices;
import com.revature.Pi2a1000Places.util.ConnectionFactory;
import com.revature.Pi2a1000Places.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.Pi2a1000Places.util.HibernateUtil;

import java.io.IOException;

public class CreditCardDao extends CreditCardServices {
    //Create creditCard
    public static CreditCard create(Object CreditCard) {

    CreditCard creditcard = new CreditCard();
    creditcard.setCCNumber("7878");
    creditcard.setCCName("Test");
    creditcard.setCvv(Integer.parseInt("888"));
    creditcard.setExpDate("12/12/28");
    creditcard.setZip(Integer.parseInt("64646"));
    creditcard.setLimit(Integer.parseInt("55000"));
    creditcard.setUserName("Name");

    try {
        SessionFactory sessionFactory = HibernateUtil.getSession().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(CreditCard);
        return new CreditCard();
        session.getTransaction().commit();
    }catch (HibernateException){
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
        System.out.println("CC Added");
        return null;
        session.close();
        sessionFactory.close();

    {

//        //Update creditCard
//    public boolean update(CreditCard updatedCreditCard){
//
//        Session session;
//        try {
//            sessionFactory = HibernateUtil.getSession().getSessionFactory();
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(creditcard);
//            return updatedCreditCard;
//            //creditCard.setCCName() ("Test")
//            session.getTransaction().commit();
//        } catch (HibernateException) {
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//
//            System.out.println("CC Updated");
//            return CreditCard;
//            session.close();
//            sessionFactory.close();
//            //where does return statement go?

        }

        //Delete creditCard
        public Boolean delete (String ccNumber){
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            CreditCard creditCard = session.load(CreditCard.class,"creditCard");
                    session.delete(creditCard);
            transaction.commit();
        } catch (HibernateException | IOException e) {
            System.out.println("CC Deleted");
        } finally {
            HibernateUtil.closeSession();
        }
        }


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

        public void update () {
        }

        public void update () {
        }

        public void update () {
        }

        public static void create () {
        }

        public static void createCC () {
        }

        public static void createCC () {
        }

        public static void createCC () {
        }

        public static void createCC () {
        }