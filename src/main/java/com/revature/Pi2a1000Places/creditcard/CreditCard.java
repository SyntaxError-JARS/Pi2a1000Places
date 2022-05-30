package com.revature.Pi2a1000Places.creditcard;

public class CreditCard {
    //CC value setup - initializing
    private String ccNumber;
    private String ccName;
    private String cvv;
    private String expDate;
    private String zip;
    private String limit;
    private String userName;

//Creating Constructors for the CC Class


    public CreditCard(String ccNumber, String ccName, String cvv, String expDate, String zip, String limit, String userName) {
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
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
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
}