package com.ps.DAOs;

import com.ps.DAOs.Interfaces.LeaseContractInt;
import com.ps.Models.LeaseContract;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractDAO implements LeaseContractInt {

    private BasicDataSource basicDataSource;

    public LeaseContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<LeaseContract> getAllLeaseContracts() {

        List<LeaseContract> leaseContracts = new ArrayList<>();

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM lease_contracts"
                );
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()) {

                LeaseContract leaseContract = generateLeaseContractFromResultSet(resultSet);
                leaseContracts.add(leaseContract);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return leaseContracts;
    }

    @Override
    public LeaseContract getOneLeaseContract(int id) {

        LeaseContract leaseContract = null;

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM lease_contracts WHERE contract_id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {
                    leaseContract = generateLeaseContractFromResultSet(resultSet);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return leaseContract;
    }

    @Override
    public void createLeaseContract(LeaseContract leaseContract) {

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO lease_contracts(contract_id, contract_date, customer_name, customer_email," +
                                "vin, lease_fee, expected_ending_value)" +
                                " VALUES(?, ?, ?, ?, ?, ?, ?)"
                );
        ) {

            generateNewLeaseContractParameters(preparedStatement, leaseContract);
            preparedStatement.executeUpdate();

            System.out.println("\n       *************************** You have successfully created a new Lease contract! *****************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateLeaseContract(int id, LeaseContract leaseContract) {

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE lease_contracts SET contract_date = ?, customer_name = ?, customer_email = ?," +
                                "vin = ?, lease_fee = ?, expected_ending_value = ?" +
                                "WHERE contract_id = ?)"
                );
        ) {

            generateUpdateLeaseContractParameters(preparedStatement, leaseContract);
            preparedStatement.executeUpdate();

            System.out.println("\n       *************************** You have successfully updated the contract! ******************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteLeaseContract(int id) {

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM lease_contracts WHERE contract_id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("\n    **************************** You have successfully removed a Lease Contract! *******************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public LeaseContract generateLeaseContractFromResultSet(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("contract_id");
        String contractDate = resultSet.getString("contract_date");
        String customerName = resultSet.getString("customer_name");
        String customerEmail = resultSet.getString("customer_email");
        int vin = resultSet.getInt("vin");

        int leaseFee = resultSet.getInt("lease_fee");
        double expectedEndingValue = resultSet.getDouble("expected_ending_value");

        return new LeaseContract(id, contractDate, customerName, customerEmail, vin,
                leaseFee, expectedEndingValue);

    }

    public void generateNewLeaseContractParameters(PreparedStatement preparedStatement, LeaseContract leaseContract) throws SQLException {

        preparedStatement.setInt(1, leaseContract.getContractId());
        preparedStatement.setString(2, leaseContract.getContractDate());
        preparedStatement.setString(3,leaseContract.getCustomerName());
        preparedStatement.setString(4, leaseContract.getCustomerEmail());

        preparedStatement.setInt(5, leaseContract.getVin());
        preparedStatement.setInt(6, leaseContract.getLeaseFee());
        preparedStatement.setDouble(7, leaseContract.getExpectedEndingValue());

    }

    public void generateUpdateLeaseContractParameters(PreparedStatement preparedStatement, LeaseContract leaseContract) throws SQLException {

        preparedStatement.setString(1, leaseContract.getContractDate());
        preparedStatement.setString(2,leaseContract.getCustomerName());
        preparedStatement.setString(3, leaseContract.getCustomerEmail());
        preparedStatement.setInt(4, leaseContract.getVin());

        preparedStatement.setInt(5, leaseContract.getLeaseFee());
        preparedStatement.setDouble(6, leaseContract.getExpectedEndingValue());
        preparedStatement.setInt(7, leaseContract.getContractId());

    }
}
