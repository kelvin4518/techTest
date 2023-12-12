package com.kz.techtest.rest.json;

public class FutureMovementResponse {
    private String clientInformation;
    private String prodcutInformation;
    private String totalTransactionAmount;

    public String getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(String clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getProdcutInformation() {
        return prodcutInformation;
    }

    public void setProdcutInformation(String prodcutInformation) {
        this.prodcutInformation = prodcutInformation;
    }

    public String getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(String totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }
}
