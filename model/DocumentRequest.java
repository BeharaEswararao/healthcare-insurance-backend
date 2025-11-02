package com.healthcare.insurance.model;

public class DocumentRequest {
    private String aadharNumber;
    private String bankAccountNumber;

    public DocumentRequest() {}

    public DocumentRequest(String aadharNumber, String bankAccountNumber) {
        this.aadharNumber = aadharNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getAadharNumber() { 
        return aadharNumber; 
    }
    
    public void setAadharNumber(String aadharNumber) { 
        this.aadharNumber = aadharNumber; 
    }

    public String getBankAccountNumber() { 
        return bankAccountNumber; 
    }
    
    public void setBankAccountNumber(String bankAccountNumber) { 
        this.bankAccountNumber = bankAccountNumber; 
    }
}