package com.ps.DAOs;

import com.ps.DAOs.Interfaces.SalesContractInt;
import com.ps.Models.SalesContract;

import java.util.List;

public class SalesContractDAO implements SalesContractInt {
    @Override
    public List<SalesContract> getAllSalesContracts() {
        return List.of();
    }

    @Override
    public SalesContract getOneSalesContract(int id) {
        return null;
    }

    @Override
    public int createSalesContract(SalesContract salesContract) {
        return 0;
    }

    @Override
    public void updateSalesContract(int id, SalesContract salesContract) {

    }

    @Override
    public void deleteSalesContract(int id) {

    }
}
