package com.ps.DAOs.Interfaces;

import com.ps.Models.LeaseContract;

import java.util.List;

public interface LeaseContractInt {

    List<LeaseContract> getAllLeaseContracts();
    LeaseContract getOneLeaseContract(int id);
    int createLeaseContract(LeaseContract leaseContract);
    void updateLeaseContract(int id, LeaseContract leaseContract);
    void deleteLeaseContract(int id);
}
