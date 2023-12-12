package com.kz.techtest.model;

public class InputRecord {
    private String recordCode;
    private String clientType;
    private String clientNumber;
    private String accountNumber;
    private String subaccountNumber;
    private String oppositePartyCode;
    private String productGroupCode;
    private String exchangeCode;
    private String symbol;
    private String expirationDate;
    private String currencyCode;
    private String movementCode;
    private String buySellCode;
    private String quantityLongSign;
    private String quantityLong;
    private String quantityShortSign;
    private String quantityShort;
    private String exchBrokerFeeDec;
    private String exchBrokerFeeDC;
    private String exchBrokerFeeCurCode;
    private String clearingFeeDec;
    private String clearingFeeDC;
    private String clearingFeeCurCode;
    private String commission;
    private String commissionDC;
    private String commissionCurCode;
    private String transactionDate;
    private String futureReference;
    private String ticketNumber;
    private String externalNumber;
    private String transactionPriceDec;
    private String traderInitials;
    private String oppositeTraderId;
    private String openCloseCode;
    private String filler;

    public InputRecord(String line) {
        this.recordCode = line.substring(0,3);
        this.clientType = line.substring(3,7);
        this.clientNumber = line.substring(7,11);
        this.accountNumber = line.substring(11,15);
        this.subaccountNumber = line.substring(15,19);
        this.oppositePartyCode = line.substring(19,25);
        this.productGroupCode = line.substring(25,27);
        this.exchangeCode = line.substring(27,31);
        this.symbol = line.substring(31,37);
        this.expirationDate = line.substring(37,45);
        this.currencyCode = line.substring(45,48);
        this.movementCode = line.substring(48,50);
        this.buySellCode = line.substring(50,51);
        this.quantityLongSign = line.substring(51,52);
        this.quantityLong = line.substring(52,62);
        this.quantityShortSign = line.substring(62,63);
        this.quantityShort = line.substring(63,73);
        this.exchBrokerFeeDec = line.substring(73,85);
        this.exchBrokerFeeDC = line.substring(85,86);
        this.exchBrokerFeeCurCode = line.substring(86,89);
        this.clearingFeeDec = line.substring(89,101);
        this.clearingFeeDC = line.substring(101,102);
        this.clearingFeeCurCode = line.substring(102,105);
        this.commission = line.substring(105,117);
        this.commissionDC = line.substring(117,118);
        this.commissionCurCode = line.substring(118,121);
        this.transactionDate = line.substring(121,129);
        this.futureReference = line.substring(129,135);
        this.ticketNumber = line.substring(135,141);
        this.externalNumber = line.substring(141,147);
        this.transactionPriceDec = line.substring(147,162);
        this.traderInitials = line.substring(162,168);
        this.oppositeTraderId = line.substring(168,175);
        this.openCloseCode = line.substring(175,176);
        this.filler = line.substring(176);
    }

    public String getRecordCode() {
        return recordCode;
    }

    public String getClientType() {
        return clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSubaccountNumber() {
        return subaccountNumber;
    }

    public String getOppositePartyCode() {
        return oppositePartyCode;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getMovementCode() {
        return movementCode;
    }

    public String getBuySellCode() {
        return buySellCode;
    }

    public String getQuantityLongSign() {
        return quantityLongSign;
    }

    public String getQuantityLong() {
        return quantityLong;
    }

    public String getQuantityShortSign() {
        return quantityShortSign;
    }

    public String getQuantityShort() {
        return quantityShort;
    }

    public String getExchBrokerFeeDec() {
        return exchBrokerFeeDec;
    }

    public String getExchBrokerFeeDC() {
        return exchBrokerFeeDC;
    }

    public String getExchBrokerFeeCurCode() {
        return exchBrokerFeeCurCode;
    }

    public String getClearingFeeDec() {
        return clearingFeeDec;
    }

    public String getClearingFeeDC() {
        return clearingFeeDC;
    }

    public String getClearingFeeCurCode() {
        return clearingFeeCurCode;
    }

    public String getCommission() {
        return commission;
    }

    public String getCommissionDC() {
        return commissionDC;
    }

    public String getCommissionCurCode() {
        return commissionCurCode;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getFutureReference() {
        return futureReference;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public String getTransactionPriceDec() {
        return transactionPriceDec;
    }

    public String getTraderInitials() {
        return traderInitials;
    }

    public String getOppositeTraderId() {
        return oppositeTraderId;
    }

    public String getOpenCloseCode() {
        return openCloseCode;
    }

    public String getFiller() {
        return filler;
    }
}
