package com.ps.DAOs;

import com.ps.DAOs.Interfaces.VehicleInt;
import com.ps.Models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleDAO implements VehicleInt {

    private BasicDataSource basicDataSource;

    public VehicleDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<Vehicle> getAllVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM dealership_db.vehicles"
                );
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while(resultSet.next()) {

                Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                vehicles.add(vehicle);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicle getOneVehicle(int id) {

        Vehicle vehicle = null;

        try(

                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE vin = ?"
                );
        ) {
            preparedStatement.setInt(1, id);

            try (

                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {

                    vehicle = generateVehicleFromResultSet(resultSet);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO vehicles(vin, year, make, model, type, color, odometer, price, sold_or_leased)" +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
        ) {
            generateNewVehicleParameters(preparedStatement, vehicle);
            preparedStatement.executeUpdate();

            System.out.println("\n    *************************** You have successfully added a new vehicle! ******************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateVehicle(int id, Vehicle vehicle) {

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE vehicles SET year = ?, make = ?, model = ?, type = ?," +
                                "color = ?, odometer = ?, price = ?, sold_or_leased = ?" +
                                "WHERE vin = ?"
                );
        ) {

            generateUpdateVehicleParameters(preparedStatement, vehicle);
            preparedStatement.executeUpdate();

            System.out.println("\n    *************************** You have successfully updated the vehicle! ******************************\n");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteVehicle(int id) {

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM vehicles WHERE vin = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("\n    **************************** You have successfully removed a vehicle! *******************************\n");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {

        List<Vehicle> vehicles = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?"
                );
        ) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();

            ) {

                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {

        List<Vehicle> vehicles = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE make = ? AND model = ?"
                );
        ) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();

            ) {

                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }



    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear){

        List<Vehicle> vehicles = new ArrayList<>();

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?"
                );
        ) {
            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {

        List<Vehicle> vehicles = new ArrayList<>(Arrays.asList());

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE color = ?"
                );
        ) {
            preparedStatement.setString(1, color);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage){

        List<Vehicle> vehicles = new ArrayList<>();

        try(

                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?"
                );
        ) {
            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {

        List<Vehicle> vehicles = new ArrayList<>();

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE type = ?"
                );
        ) {
            preparedStatement.setString(1, vehicleType);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {
                    Vehicle vehicle = generateVehicleFromResultSet(resultSet);
                    vehicles.add(vehicle);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public Vehicle generateVehicleFromResultSet(ResultSet resultSet) throws SQLException {

        int vin = resultSet.getInt("vin");
        int year = resultSet.getInt("year");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String type = resultSet.getString("type");
        String color = resultSet.getString("color");
        int odometer = resultSet.getInt("odometer");
        double price = resultSet.getDouble("price");
        String soldOrLeased = resultSet.getString("sold_or_leased");

        return new Vehicle(vin, year, make, model, type, color, odometer, price, soldOrLeased);
    }

    public void generateNewVehicleParameters(PreparedStatement preparedStatement, Vehicle vehicle) throws SQLException {

        preparedStatement.setInt(1, vehicle.getVin());
        preparedStatement.setInt(2, vehicle.getYear());
        preparedStatement.setString(3, vehicle.getMake());
        preparedStatement.setString(4, vehicle.getModel());
        preparedStatement.setString(5, vehicle.getVehicleType());

        preparedStatement.setString(6, vehicle.getColor());
        preparedStatement.setInt(7, vehicle.getOdometer());
        preparedStatement.setDouble(8, vehicle.getPrice());
        preparedStatement.setString(9, vehicle.getSoldOrLeased());

    }

    public void generateUpdateVehicleParameters(PreparedStatement preparedStatement, Vehicle vehicle) throws SQLException {

        preparedStatement.setInt(1, vehicle.getYear());
        preparedStatement.setString(2, vehicle.getMake());
        preparedStatement.setString(3, vehicle.getModel());
        preparedStatement.setString(4, vehicle.getVehicleType());

        preparedStatement.setString(5, vehicle.getColor());
        preparedStatement.setInt(6, vehicle.getOdometer());
        preparedStatement.setDouble(7, vehicle.getPrice());
        preparedStatement.setString(8, vehicle.getSoldOrLeased());
        preparedStatement.setInt(9, vehicle.getVin());

    }
}
