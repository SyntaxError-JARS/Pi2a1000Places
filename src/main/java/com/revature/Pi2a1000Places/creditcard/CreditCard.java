package com.revature.Pi2a1000Places.creditcard;

public class CreditCard {
    //CC value setup - initializing
    private String ccNumber;
    private String ccName;
    private int cvv;
    private String expDate;
    private int zip;
    private int limit;
    private String userName;

//Creating Constructors for the CC Class


    public CreditCard(String ccNumber, String ccName, int cvv, String expDate, int zip, int limit, String userName) {
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limit = limit;
        this.userName = userName;
    }

    public CreditCard() {

    }

    //Generate Getters/Setters
    public String getCCNumber() {
        return ccNumber;
    }

    public void setCCNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCCName() {
        return ccName;
    }

    public void setCCName(String ccName) {
        this.ccName = ccName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ccNumber='" + ccNumber + '\'' +
                ", ccName='" + ccName + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expDate='" + expDate + '\'' +
                ", zip='" + zip + '\'' +
                ", limit='" + limit + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public void setCCardNumber(String s) {
    }
}