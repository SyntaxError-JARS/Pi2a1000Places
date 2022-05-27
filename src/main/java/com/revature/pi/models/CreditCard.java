package com.revature.pi.models;

public class CreditCard {

    private String ccNumber;
    private String ccName;
    private String cvv;
    private String expDate;
    private String zip;
    private String limit;
    private String userName;


    public CreditCard(String ccNumber, String ccName, String cvv, String expDate, String zip, String limit, String userName) {
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limit = limit;
        this.userName = userName;

    }

    public String getCardNumber() {
        return ccNumber;
    }

    public String getCardName() {
        return ccName;
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

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
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
    }

    public String setUserName(String userName) {
        this.userName = userName;
        {
        }
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(ccNumber).append(",")
                .append(ccName).append(",")
                .append(cvv).append(",")
                .append(expDate).append(",")
                .append(zip).append(",")
                .append(limit).append(",")
                .append(userName);
        return mutableString.toString();
    }
}