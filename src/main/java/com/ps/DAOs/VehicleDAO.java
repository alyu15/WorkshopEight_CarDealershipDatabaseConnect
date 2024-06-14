package com.ps.DAOs;

import com.ps.DAOs.Interfaces.VehicleInt;
import com.ps.Models.Vehicle;

import java.util.List;

public class VehicleDAO implements VehicleInt {

    @Override
    public List<Vehicle> getAllVehicles() {
        return List.of();
    }

    @Override
    public Vehicle getOneVehicle(int id) {
        return null;
    }

    @Override
    public int createVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public void updateVehicle(int id, Vehicle vehicle) {

    }

    @Override
    public void deleteVehicle(int id) {

    }
}
