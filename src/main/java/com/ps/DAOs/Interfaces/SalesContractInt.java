package com.ps.DAOs.Interfaces;

import com.ps.Models.SalesContract;

import java.util.List;

public interface SalesContractInt {

    List<SalesContract> getAllSalesContracts();
    SalesContract getOneSalesContract(int id);
    int createSalesContract(SalesContract salesContract);
    void updateSalesContract(int id, SalesContract salesContract);
    void deleteSalesContract(int id);
}
