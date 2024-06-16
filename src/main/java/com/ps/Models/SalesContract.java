package com.ps.Models;

public class SalesContract extends Contract {

    private float salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private String financeChoice;

    public SalesContract(int contractId, String contractDate, String customerName, String customerEmail, int vin,
                         float salesTaxAmount, int recordingFee, int processingFee, String financeChoice) {

        super(contractId, contractDate, customerName, customerEmail, vin);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeChoice = financeChoice;
    }

    public SalesContract(String contractDate, String customerName, String customerEmail, int vin,
                         float salesTaxAmount, int recordingFee, int processingFee, String financeChoice) {

        super(contractDate, customerName, customerEmail, vin);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeChoice = financeChoice;
    }

    public float getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(float salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public String getFinanceChoice() {
        return financeChoice;
    }

    public void setFinanceChoice(String financeChoice) {
        this.financeChoice = financeChoice;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", financeChoice='" + financeChoice + '\'' +
                '}';
    }
}

