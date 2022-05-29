package com.revature.Pi2a1000Places.creditcard;
import com.revature.Pi2a1000Places.util.exceptions.ResourcePersistenceException;

import java.io.IOException;
public class CreditCardServices extends CreditCardDao {


    private CreditCard cc = new CreditCard();
    private CreditCardDao ccDao = new CreditCardDao();
    //CreditCard Class is now = cc. CreditCardDao Class is now = ccDao.


    public CreditCard create(CreditCard newCreditCard){
        System.out.println("Adding Credit Card...: " + newCreditCard);
        if(validateCreditCardInput(new CreditCard())) {
            System.out.println("Credit Card Was Not Validated");
            throw new RuntimeException();
        }

        CreditCard persistedCreditCard = ccDao.create(new CreditCard());

        if(persistedCreditCard == null){
            throw new ResourcePersistenceException();
        }
        System.out.println("CreditCard Persisted: " + new CreditCard());
        return true;
    }

        public CreditCard[] findAll() throws IOException {
        return null;
        }
        public Object findById(String username) {
        return null;
        }
        boolean delete(String username) {
            return delete(String username);
        }
    private boolean validateCreditCardInput(CreditCard cc) {
        System.out.println("Validating CreditCard: " + cc);
        if(cc == null) return false;
        else if(cc.getCcNumber() == null || cc.getCcNumber().trim().equals("")) return false;
        else if(cc.getCcName() == null || cc.getCcName().trim().equals("")) return false;
        else if(cc.getCvv() == null || cc.getCvv().trim().equals("")) return false;
        else if(cc.getExpDate() == null || cc.getExpDate().trim().equals("")) return false;
        else if(cc.getZip() == null || cc.getZip().trim().equals("")) return false;
        else if(cc.getLimit() == null || cc.getLimit().trim().equals("")) return false;
        return cc.getUserName() != null || cc.getUserName().trim().equals("");
    }
}