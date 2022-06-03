package com.revature.Pi2a1000Places.creditcard;

public class CreditCardServices {
    private final CreditCardDao creditCardDao;

    public CreditCardServices(CreditCardDao creditCardDao) {
        this.creditCardDao = creditCardDao;
    }

    //@Override
    public CreditCard create(CreditCard newCreditCard) {
        return creditCardDao.create(new CreditCard());
    }

    //@Override
    public CreditCard update(CreditCard updatedCreditCard) {
        if (!creditCardDao.update(updatedCreditCard)) return null;

        return updatedCreditCard;
    }

    //Override
    public boolean delete() {
        return delete(null);
    }

    // Override
    public boolean delete(String userName) {

        return true;
    }
}