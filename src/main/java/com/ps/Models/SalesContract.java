package com.ps.Models;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private int recordingFee = 100;
    private int processingFee;
    private boolean financeChoice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeChoice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        if(vehicleSold.getPrice() < 10_000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.financeChoice = financeChoice;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public boolean isFinanceChoice() {
        return financeChoice;
    }

    public void setFinanceChoice(boolean financeChoice) {
        this.financeChoice = financeChoice;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", financeChoice=" + financeChoice +
                "}\n";
    }
}

