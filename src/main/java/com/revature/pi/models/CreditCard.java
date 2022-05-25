package com.revature.pi.models;

public class CreditCard {

    private String cardNumber;
    private String cardName;
    private String cvv;
    private String expDate;
    private String zip;
    private String limit;
    private String userName;


    public CreditCard(String cardName, String cvv, String expDate, String zip, String limit, String userName) {
        this.cardName = cardName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limit = limit;
        this.userName = userName;

    }

    public String getCardName() {
        return cardName;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getZip() {
        return zip;
    }

    public String getLimit() {
        return limit;
    }

    public String getUserName() {
        return userName;
    }

    public void setCardNumber(String cardName) {
        this.cardName = cardName;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setLimit(String limit) {
        this.limit = limit;
        {
        }
    }
}