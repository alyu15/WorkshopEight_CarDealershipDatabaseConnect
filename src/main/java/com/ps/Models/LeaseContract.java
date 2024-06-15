package com.ps.Models;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(int contractId, String contractDate, String customerName, String customerEmail, int vin, double expectedEndingValue, double leaseFee) {
        super(contractId, contractDate, customerName, customerEmail, vin);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                '}';
    }
}

