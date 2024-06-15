package com.ps.UserInterfaces;

import com.ps.DAOs.LeaseContractDAO;
import com.ps.DAOs.SalesContractDAO;
import com.ps.DAOs.VehicleDAO;
import com.ps.Models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class MainUserInterface {

    private static VehicleDAO vehicleDAO;
    private static SalesContractDAO salesContractDAO;
    private static LeaseContractDAO leaseContractDAO;

    static Scanner scanner = new Scanner(System.in);


    public static void init(String[] args) {

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);

        vehicleDAO = new VehicleDAO(basicDataSource);
        salesContractDAO = new SalesContractDAO(basicDataSource);
        leaseContractDAO = new LeaseContractDAO(basicDataSource);

    }

    public static void display(String[] args) {

        init(args);

        System.out.println("\n************************************* Welcome to the World Famous Car Dealership Application! ************************************");
        System.out.println("                                                  --  How may we help you?  --");
        System.out.println("**********************************************************************************************************************************");

//        Vehicle vehicle = vehicleDAO.getOneVehicle(1);
//        vehicle.setSoldOrLeased("leased");
//
//        vehicleDAO.updateVehicle(1, vehicle);
        handleMainMenu();

    }

    public static void handleMainMenu() {

        String mainMenuInput;

        do {

            System.out.println("\n==================================================================================================================================");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View All Vehicles");
            System.out.println("~ (2) Browse Vehicles By Filter");
            System.out.println("~ (3) Manage Vehicles");
            System.out.println("~ (4) Manage Sales and Leases");
            System.out.println("~ (0) Exit");

            mainMenuInput = scanner.next();

            switch(mainMenuInput) {

                case "1":
                    System.out.println("\n====================================================== View All Vehicles =========================================================");
                    List<Vehicle> allVehicles = vehicleDAO.getAllVehicles();
                    displayVehicles(allVehicles);
                    break;

                case "2":
                    handleVehiclesFilterMenu();
                    break;

                case "3":
                    handleManageVehiclesMenu();
                    break;

                case "4":
                    SalesAndLeases.handleMenu();
                    break;

                case "0":
                    System.out.println("\n*******************************************************  Exiting program... ******************************************************");
                    System.out.println("                                                     --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("                                 ********************* Command not found *********************");
                    System.out.println("                                                     -- Please try again --");
                    break;
            }

        } while(!mainMenuInput.equals("0"));

    }

    public static void handleVehiclesFilterMenu() {

        String subMenuInput;

        do {
            System.out.println("**********************************************************************************************************************************");
            System.out.println("================================================== Browse Vehicles By Filter =====================================================\n");
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
                    handleGetByPrice();
                    break;

                case "2":
                    handleGetByMakeModel();
                    break;

                case "3":
                    handleGetByYear();
                    break;

                case "4":
                    handleGetByColor();
                    break;

                case "5":
                    handleGetByMileage();
                    break;

                case "6":
                    handleGetByType();
                    break;

                case "0":
                    System.out.println("**********************************************************************************************************************************");
                    System.out.println("=======================================================  Welcome Back!  ==========================================================");
                    break;

                default:
                    handleMisinputs();
                    break;
            }

        } while(!subMenuInput.equals("0"));

    }

    public static void handleManageVehiclesMenu() {

        String managingVehiclesInput;

        do {
            System.out.println("*************************************************************************************************************************************************");
            System.out.println("===========================================  Manage Vehicles  ===============================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) Add a Vehicle");
            System.out.println("~ (2) Remove a Vehicle");
            System.out.println("~ (0) Return to HOME menu");

            managingVehiclesInput = scanner.next().trim();

            switch (managingVehiclesInput) {
                case "1":

                    break;

                case "2":

                    break;

                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    handleMisinputs();
                    break;
            }

        } while (!managingVehiclesInput.equals("0"));

    }


    public static void handleGetByPrice() {

        System.out.println("\n========================================= View Vehicles By Price ============================================");
        System.out.println("\n* Please enter in the minimum price of the vehicle you are searching for:");
            double minPrice;
                while(true) {
                    if (scanner.hasNextDouble()) {
                        minPrice = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the maximum price of the vehicle you are searching for:");
            double maxPrice;
                while(true) {
                    if (scanner.hasNextDouble()) {
                        maxPrice = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        List<Vehicle> vehiclesByPrice = vehicleDAO.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);

    }

    public static void handleGetByMakeModel() {

        System.out.println("\n====================================== View Vehicles By Make/Model ==========================================");
        System.out.println("\n* Please enter in the make of the vehicle you are searching for:");
            String make;
                while (true) {
                    make = scanner.next().trim();
                    if (make.isEmpty()) {
                        System.out.println("* Please enter in a vehicle make.");
                    } else {
                        break;
                    }
                }

        System.out.println("* Please enter in the model of the vehicle you are searching for:");
            String model;
                while (true) {
                    model = scanner.next().trim();
                    if (model.isEmpty()) {
                        System.out.println("* Please enter in a vehicle model.");
                    } else {
                        break;
                    }
                }

        List<Vehicle> vehiclesByMakeModel = vehicleDAO.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);

    }

    public static void handleGetByYear() {

        System.out.println("\n========================================= View Vehicles By Year =============================================");
        System.out.println("\n* Please enter in the minimum year of the vehicle you are searching for:");
            int minYear;
                while(true) {
                    if (scanner.hasNextInt()) {
                        minYear = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the maximum year of the vehicle you are searching for:");
            int maxYear;
                while(true) {
                    if (scanner.hasNextInt()) {
                        maxYear = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        List<Vehicle> vehiclesByYear = vehicleDAO.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehiclesByYear);

    }

    public static void handleGetByColor() {

        System.out.println("\n======================================== View Vehicles By Color =============================================");
        System.out.println("* Please enter in the color of the vehicle you are searching for:");
            String color;
                while (true) {
                    color = scanner.next().trim();
                    if (color.matches(".*\\d.*") || color.isEmpty()) {
                        System.out.println("* Please enter in a color.");
                    } else {
                        break;
                    }
                }

        List<Vehicle> vehicles = vehicleDAO.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    public static void handleGetByMileage() {

        System.out.println("\n======================================== View Vehicles By Mileage ===========================================");
        System.out.println("\n* Please enter in the minimum mileage of the vehicle you are searching for:");
            int minMileage;
                while(true) {
                    if (scanner.hasNextInt()) {
                        minMileage = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the maximum mileage of the vehicle you are searching for:");
            int maxMileage;
                while(true) {
                    if (scanner.hasNextInt()) {
                        maxMileage = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        List<Vehicle> vehiclesByMileage = vehicleDAO.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehiclesByMileage);

    }

    public static void handleGetByType() {

        System.out.println("\n====================================== View Vehicles By Vehicle Type ========================================");
        System.out.println("\n* Please enter in the type of vehicle you are searching for:");
            String vehicleType;
                while (true) {
                    vehicleType = scanner.next().trim();
                    if (vehicleType.matches(".*\\d.*") || vehicleType.isEmpty()) {
                        System.out.println("* Please enter in a vehicle type.");
                    } else {
                        break;
                    }
                }

        List<Vehicle> vehicles = vehicleDAO.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    public static void displayVehicles(List<Vehicle> vehicles) {

        System.out.println("\n**********************************************  Vehicles  ***************************************************");

        for(Vehicle vehicle: vehicles) {
            System.out.printf("~ VIN: %d    Year: %d    %-14s %-14s   %-12s   %-8s  Mileage: %-8d   $%-10.2f   %-10s\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice(),
                    vehicle.getSoldOrLeased()
            );
        }

        if(vehicles.isEmpty()) {
            System.out.println("\n           ******************************** No vehicle founds ********************************");
        }

    }

    public static void handleMisinputs() {
        System.out.println("                                 ********************* Command not found *********************");
        System.out.println("                                                     -- Please try again --");
    }


}
