package com.revature.Pi2a1000Places.creditcard;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.*;

public class CreditCardServices {


    @Id
    @Column(name="CCNUMBER")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ccNumber;

    @Column(name="CCNAME")
    private String ccName;
    @Column(name="CVV")
    private int cVv;
    @Column(name="EXPDATE")
    private String expDate;
    @Column(name="ZIP")
    private int zip;
    @Column(name="LIMIT")
    private String limit;
    @Column(name="USERNAME")
    private String userName;



        public int getCCNumber() {
        return ccNumber;
    }
        public void setCcNumber(int ccNumber) {
        this.ccNumber = ccNumber;
    }
        public String getCCName() {
        return ccName;
    }

    public int getCvV() {
        return cVv;
    }
    public void setcVv(int cVv) {
        this.cVv = cVv;
    }
    public String getExpDate() {
        return expDate;
    }
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getLimit() {
        return limit;
    }
    public void setLimit(String limit) {
        this.limit = limit;
    }
    public String getUserName() {return userName;}
    public void setUserName(String userName) {
        this.userName = userName;
    }
}


