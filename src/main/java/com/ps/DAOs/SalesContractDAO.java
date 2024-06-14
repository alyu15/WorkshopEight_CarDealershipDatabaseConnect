package com.ps.DAOs;

import com.ps.DAOs.Interfaces.SalesContractInt;
import com.ps.Models.SalesContract;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class SalesContractDAO implements SalesContractInt {

    private BasicDataSource basicDataSource;

    public SalesContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

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
