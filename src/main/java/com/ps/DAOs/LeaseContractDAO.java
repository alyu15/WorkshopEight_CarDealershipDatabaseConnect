package com.ps.DAOs;

import com.ps.DAOs.Interfaces.LeaseContractInt;
import com.ps.Models.LeaseContract;

import java.util.List;

public class LeaseContractDAO implements LeaseContractInt {
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
