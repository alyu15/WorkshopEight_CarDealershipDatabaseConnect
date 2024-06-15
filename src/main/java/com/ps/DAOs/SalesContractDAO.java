package com.ps.DAOs;

import com.ps.DAOs.Interfaces.SalesContractInt;
import com.ps.Models.SalesContract;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDAO implements SalesContractInt {

    private BasicDataSource basicDataSource;

    public SalesContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<SalesContract> getAllSalesContracts() {

        List<SalesContract> salesContracts = new ArrayList<>();

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM sales_contracts"
                );
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()) {

                SalesContract salesContract = generateSalesContractFromResultSet(resultSet);
                salesContracts.add(salesContract);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return salesContracts;
    }

    @Override
    public SalesContract getOneSalesContract(int id) {

        SalesContract salesContract = null;

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM sales_contracts WHERE contract_id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()) {
                    salesContract = generateSalesContractFromResultSet(resultSet);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return salesContract;
    }

    @Override
    public void createSalesContract(SalesContract salesContract) {

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO sales_contracts(contract_id, contract_date, customer_name, customer_email," +
                                "vin, sales_tax_amount, recording_fee, processing_fee, is_financing)" +
                                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
        ) {

            generateNewSalesContractParameters(preparedStatement, salesContract);
            preparedStatement.executeUpdate();

            System.out.println("\n       *************************** You have successfully created a new Sales contract! *****************************");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSalesContract(int id, SalesContract salesContract) {

        try(
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE sales_contracts SET contract_date = ?, customer_name = ?, customer_email = ?," +
                                "vin = ?, sales_tax_amount = ?, recording_fee = ?, processing_fee = ?, is_financing = ?" +
                                "WHERE contract_id = ?)"
                );
        ) {

            generateUpdateSalesContractParameters(preparedStatement, salesContract);
            preparedStatement.executeUpdate();

            System.out.println("\n       *************************** You have successfully updated the contract! ******************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteSalesContract(int id) {

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM sales_contracts WHERE contract_id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("\n    **************************** You have successfully removed a Sales Contract! *******************************");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public SalesContract generateSalesContractFromResultSet(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("contract_id");
        String contractDate = resultSet.getString("contract_date");
        String customerName = resultSet.getString("customer_name");
        String customerEmail = resultSet.getString("customer_email");
        int vin = resultSet.getInt("vin");

        float salesTaxAmount = resultSet.getFloat("sales_tax_amount");
        int recordingFee = resultSet.getInt("recording_fee");
        int processingFee = resultSet.getInt("processing_fee");
        String isFinancing = resultSet.getString("is_financing");

        return new SalesContract(id, contractDate, customerName, customerEmail, vin, salesTaxAmount,
                recordingFee, processingFee, isFinancing);
    }

    public void generateNewSalesContractParameters(PreparedStatement preparedStatement, SalesContract salesContract) throws SQLException {

        preparedStatement.setInt(1, salesContract.getContractId());
        preparedStatement.setString(2, salesContract.getContractDate());
        preparedStatement.setString(3,salesContract.getCustomerName());
        preparedStatement.setString(4, salesContract.getCustomerEmail());

        preparedStatement.setInt(5, salesContract.getVin());
        preparedStatement.setFloat(6, salesContract.getSalesTaxAmount());
        preparedStatement.setInt(7, salesContract.getRecordingFee());
        preparedStatement.setString(8, salesContract.getFinanceChoice());

    }

    public void generateUpdateSalesContractParameters(PreparedStatement preparedStatement, SalesContract salesContract) throws SQLException {

        preparedStatement.setString(1, salesContract.getContractDate());
        preparedStatement.setString(2,salesContract.getCustomerName());
        preparedStatement.setString(3, salesContract.getCustomerEmail());
        preparedStatement.setInt(4, salesContract.getVin());

        preparedStatement.setFloat(5, salesContract.getSalesTaxAmount());
        preparedStatement.setInt(6, salesContract.getRecordingFee());
        preparedStatement.setString(7, salesContract.getFinanceChoice());
        preparedStatement.setInt(8, salesContract.getContractId());

    }
}
