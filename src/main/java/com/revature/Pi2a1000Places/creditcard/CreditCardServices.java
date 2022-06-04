//package com.revature.Pi2a1000Places.creditcard;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
//public class CreditCardServices {
//    private final CreditCardDao creditCardDao;
//
//    @Id
//    @Column(name="CCNUMBER")
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int ccNumber;
//
//    //@Override
//    public CreditCard create(CreditCard newCreditCard){
//        return creditCardDao.create(new CreditCard());
//    }
//    //@Override
//    public CreditCard update(CreditCard updatedCreditCard) {
//        if (creditCardDao.update(updatedCreditCard)) return null;
//
//        return updatedCreditCard;
//    }
//
//    //Override
//    public boolean delete() {
//        return delete(null);
//    }
//
//   // Override
//    public boolean delete(String ccNumber){
//
//        return true;
//    }
//
//
//    @Column(name="CCNAME")
//    private String ccName;
//    @Column(name="CVV")
//    private int cVv;
//    @Column(name="EXPDATE")
//    private String expDate;
//    @Column(name="ZIP")
//    private int zip;
//    @Column(name="LIMIT")
//    private String limit;
//    @Column(name="USERNAME")
//    private String userName;
//
//}