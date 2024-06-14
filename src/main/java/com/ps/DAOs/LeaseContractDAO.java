package com.ps.DAOs;

import com.ps.DAOs.Interfaces.LeaseContractInt;
import com.ps.Models.LeaseContract;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class LeaseContractDAO implements LeaseContractInt {

    private BasicDataSource basicDataSource;

    public LeaseContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<LeaseContract> getAllLeaseContracts() {
        return List.of();
    }

    @Override
    public LeaseContract getOneLeaseContract(int id) {
        return null;
    }

    @Override
    public int createLeaseContract(LeaseContract leaseContract) {
        return 0;
    }

    @Override
    public void updateLeaseContract(int id, LeaseContract leaseContract) {

    }

    @Override
    public void deleteLeaseContract(int id) {

    }
}
