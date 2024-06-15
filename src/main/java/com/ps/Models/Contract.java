package com.ps.Models;

public abstract class Contract {

    private int contractId;
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private int vin;

    public Contract(int contractId, String contractDate, String customerName, String customerEmail, int vin) {
        this.contractId = contractId;
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vin = vin;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

}

