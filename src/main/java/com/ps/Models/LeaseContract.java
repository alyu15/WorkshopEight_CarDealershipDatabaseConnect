package com.ps.Models;

public class LeaseContract extends Contract{

    private int leaseFee;
    private double expectedEndingValue;

    public LeaseContract(int contractId, String contractDate, String customerName,
                         String customerEmail, int vin, int leaseFee, double expectedEndingValue) {

        super(contractId, contractDate, customerName, customerEmail, vin);
        this.leaseFee = leaseFee;
        this.expectedEndingValue = expectedEndingValue;
    }

    public int getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(int leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "leaseFee=" + leaseFee +
                ", expectedEndingValue=" + expectedEndingValue +
                '}';
    }
}

