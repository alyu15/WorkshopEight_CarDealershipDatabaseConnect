package com.ps.DAOs.Interfaces;

import com.ps.Models.Vehicle;

import java.util.List;

public interface VehicleInt {

    List<Vehicle> getAllVehicles();
    Vehicle getOneVehicle(int id);
    void createVehicle(Vehicle vehicle);
    void updateVehicle(int id, Vehicle vehicle);
    void deleteVehicle(int id);
}
