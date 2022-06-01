package com.revature.Pi2a1000Places.creditcard;

import com.revature.Pi2a1000Places.util.ConnectionFactory;
import com.revature.Pi2a1000Places.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class CreditCardDao {

        private Logger logger = Logger.getLogger();

        // MVP a. Create - ADD Card
        public CreditCard addCC(String ccNumber, String ccName, String cvv, String expDate, String zip, String limits, String customerUsername) {
            try(Connection conn = ConnectionFactory.getInstance().getConnection();){
                String sql = "insert into credit_card values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1,ccNumber);
                ps.setString(2, ccName);
                ps.setString(3, cvv);
                ps.setString(4, expDate);
                ps.setString(5, zip);
                ps.setString(6, limits);
                ps.setString(7, customerUsername);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0){
                    throw new RuntimeException();
                }

            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
            return null;
        }


        // MVP b. Update - UPDATE Card
        public static CreditCard update(Object updatedObject) {
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

//    d.   Pay off your balance with your credit card  > Update (to the limit)
//4.5 (for credit card update and update limit see do get in trainer servlet )