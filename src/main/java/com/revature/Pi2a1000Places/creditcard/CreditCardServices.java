package com.revature.Pi2a1000Places.creditcard;
import com.revature.Pi2a1000Places.creditcard.CreditCardDao;

import java.io.IOException;
public class CreditCardServices {


    private CreditCard cc = new CreditCard();
    private CreditCardDao ccDao = new CreditCardDao();
    //CreditCard Class is now = cc. CreditCardDao Class is now = ccDao.


    public boolean create(CreditCard newCreditCard){
        System.out.println("CreditCard trying to be registered: " + newCreditCard);
        if(validateCreditCardInput(new CreditCard())){
            System.out.println("User was not validated");
            throw new RuntimeException();
        }

//            public void CreditCard;{
//                System.out.println("Begin reading CreditCards in our file database.");
//                CreditCard[] CreditCards = new CreditCard[0];
//                try {
//                    CreditCards = creditCardDao.findAll();
//                    System.out.println("All CreditCards have been found here are the results: \n");
//
//                } catch (IOException | NullPointerException e) {
//                    // e.printStackTrace();

        CreditCard persistedCreditCard = ccDao.create(new CreditCard());

        if(persistedCreditCard == null){
            throw new RuntimeException();
        }
        System.out.println("CreditCard has been persisted: " + new CreditCard());
        return true;
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