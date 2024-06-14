package com.ps;

import com.ps.DAOs.DealershipDAO;
import com.ps.DAOs.LeaseContractDAO;
import com.ps.DAOs.SalesContractDAO;
import com.ps.DAOs.VehicleDAO;
import com.ps.Models.Dealership;
import com.ps.Models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static VehicleDAO vehicleDAO;
    private static DealershipDAO dealershipDAO;
    private static SalesContractDAO salesContractDAO;
    private static LeaseContractDAO leaseContractDAO;

    private static Dealership currentDealership;

    private static Scanner scanner = new Scanner(System.in);


    public static void init(String[] args) {

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);

        vehicleDAO = new VehicleDAO(basicDataSource);
        dealershipDAO = new DealershipDAO(basicDataSource);
        salesContractDAO = new SalesContractDAO(basicDataSource);
        leaseContractDAO = new LeaseContractDAO(basicDataSource);

    }

    public static void display(String[] args) {
        init(args);

        System.out.println("\n************************** Welcome to the World Famous Car Dealership Application! **************************");
        System.out.println("                                       --  How may we help you?  --");
        System.out.println("*************************************************************************************************************");

//        Vehicle vehicle = vehicleDAO.getOneVehicle(1);
//        vehicle.setSoldOrLeased("leased");
//
//        vehicleDAO.updateVehicle(1, vehicle);
        processMainMenu();

    }

    public static void processMainMenu() {

        String mainMenuInput;

        do {

            System.out.println("\n=============================================================================================================");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View All Vehicles");
            System.out.println("~ (2) Browse Vehicles By Filter");
            System.out.println("~ (3) Manage Vehicles");
            System.out.println("~ (0) Exit");

            mainMenuInput = scanner.next();

            switch(mainMenuInput) {

                case "1":
                    System.out.println("\n=========================================== View All Vehicles ===============================================");
                    System.out.println("\n**********************************************  Vehicles  ***************************************************");
                    vehicleDAO.getAllVehicles();
                    break;

                case "2":
                    processVehiclesFilterMenu();
                    break;

                case "3":
                    processManageVehiclesMenu();
                    break;

                case "0":
                    System.out.println("********************************************  Exiting program... ********************************************");
                    System.out.println("                                          --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while(!mainMenuInput.equals("0"));

    }

    public static void processVehiclesFilterMenu() {

        String subMenuInput;

        do {
            System.out.println("\n*************************************************************************************************************");
            System.out.println("======================================= Browse Vehicles By Filter ===========================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View Vehicles by Price");
            System.out.println("~ (2) View Vehicles by Make/Model");
            System.out.println("~ (3) View Vehicles by Year");
            System.out.println("~ (4) View Vehicles by Color");
            System.out.println("~ (5) View Vehicles by Mileage");
            System.out.println("~ (6) View Vehicles by Type");
            System.out.println("~ (0) Return to HOME menu");

            subMenuInput = scanner.next().trim();

            switch(subMenuInput) {
                case "1":

                    break;

                case "2":

                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;

                case "6":

                    break;
                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while(!subMenuInput.equals("0"));

    }

    public static void processManageVehiclesMenu() {

        String managingVehiclesInput;

        do {
            System.out.println("\n*************************************************************************************************************");
            System.out.println("===========================================  Manage Vehicles  ===============================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) Add a Vehicle");
            System.out.println("~ (2) Remove a Vehicle");
            System.out.println("~ (3) Sell/Lease a Vehicle");
            System.out.println("~ (0) Return to HOME menu");

            managingVehiclesInput = scanner.next().trim();

            switch (managingVehiclesInput) {
                case "1":

                    break;

                case "2":

                    break;

                case "3":

                    break;

                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while (!managingVehiclesInput.equals("0"));

    }

}
