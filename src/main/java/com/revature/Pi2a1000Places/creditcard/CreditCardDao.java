package com.revature.Pi2a1000Places.creditcard;

import com.revature.Pi2a1000Places.util.ConnectionFactory;
import com.revature.Pi2a1000Places.util.exceptions.ResourcePersistenceException;
import com.revature.Pi2a1000Places.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class CreditCardDao {

        private Logger logger = Logger.getLogger();

        // MVP a. Create - ADD Card
        public CreditCard create(CreditCard newCreditCard) {
            System.out.println("newCreditCard Entering Dao" + newCreditCard);

            try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
                String sql = "insert into CreditCard (ccnumber, ccname, ccv, expdate, zip, limit, username) values (?, ?, ?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(sql);

                System.out.println(newCreditCard.getCcNumber());
                System.out.println(newCreditCard.getUserName());

                // CC String Index
                ps.setString(1, newCreditCard.getCcNumber());
                ps.setString(2, newCreditCard.getCcName());
                ps.setString(3, newCreditCard.getCvv());
                ps.setString(4, newCreditCard.getExpDate());
                ps.setString(5, newCreditCard.getZip());
                ps.setString(6, newCreditCard.getLimit());
                ps.setString(7, newCreditCard.getUserName());

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new ResourcePersistenceException("Credit Card Not Updated.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return newCreditCard;
        }

        //Read- NOT MVP!!!!

//        public CreditCard[] findAll() throws IOException {
//            try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//
//                String sql = "select * from CreditCard";
//                Statement s = conn.createStatement();
//                ResultSet rs = s.executeQuery(sql);
//
//                while (rs.next()) {
//                    CreditCard newCC = new CreditCard();
//
//                    newCC.setCcNumber(rs.getString("ccNumber")); // this column label MUST MATCH THE DB
//                    newCC.setCcName(rs.getString("ccName"));
//                    newCC.setCvv(rs.getString("cvv"));
//                    newCC.setExpDate(rs.getString("expDate"));
//                    newCC.setZip(rs.getString("zip"));
//                    newCC.setLimit(rs.getString("limit"));
//                    newCC.setUserName(rs.getString("userName"));
//
//                    System.out.println("Going to the next line for our following index.");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
 //           }

//            // NOT MVP!!!!!!
//            public Object findById(String username) {
//
//            try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//
//                String sql = "select * from creditCard where userName = ?";
//
//                PreparedStatement ps = conn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//
//                if (!rs.next()) {
//                    throw new ResourcePersistenceException("Credit Card Not Found");
//                }
//
//                CreditCard CreditCard = new CreditCard();
//
//                CreditCard.setCcNumber(rs.getString("ccNumber")); // this column label MUST MATCH THE DB
//                CreditCard.setCcName(rs.getString("ccName"));
//                CreditCard.setCvv(rs.getString("cvv"));
//                CreditCard.setExpDate(rs.getString("expDate"));
//                CreditCard.setZip(rs.getString("zip"));
//                CreditCard.setLimit(rs.getString("limit"));
//                CreditCard.setUserName(rs.getString("userName"));
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            } } }

        // MVP b. Update - UPDATE Card
        public CreditCard update(Object updatedObject) {
            return null;
        }

        //// MVP c. Delete - DELETE Card
        public boolean deleteByCCNumber(String ccNumber) {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            {
                String sql = "delete from credit_card where cc_number = ?";

                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, ccNumber);

                    int checkInsert = ps.executeUpdate();

                    if (checkInsert == 0) {
                        throw new RuntimeException();
                    }

                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            return false;
        }
    }

//    4   Pay off your balance with your credit card  > Update (to the limit)
//4.5 (for credit card update and update limit see do get in trainer servlet )