package com.ps.DAOs;

import com.ps.DAOs.Interfaces.DealershipInt;
import com.ps.Models.Dealership;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class DealershipDAO implements DealershipInt {

    private BasicDataSource basicDataSource;

    public DealershipDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<Dealership> getAllDealerships() {
        return List.of();
    }

    @Override
    public Dealership getOneDealership(int id) {
        return null;
    }

    @Override
    public int createDealership(Dealership dealership) {
        return 0;
    }

    @Override
    public void updateDealership(int id, Dealership dealership) {

    }

    @Override
    public void deleteDealership(int id) {

    }
}