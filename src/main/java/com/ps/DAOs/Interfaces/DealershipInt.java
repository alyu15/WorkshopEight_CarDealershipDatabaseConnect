package com.ps.DAOs.Interfaces;

import com.ps.Models.Dealership;

import java.util.List;

public interface DealershipInt {

    List<Dealership> getAllDealerships();
    Dealership getOneDealership(int id);
    int createDealership(Dealership dealership);
    void updateDealership(int id, Dealership dealership);
    void deleteDealership(int id);

}
