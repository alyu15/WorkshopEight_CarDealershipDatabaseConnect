package com.ps.UserInterfaces;

import com.ps.DAOs.LeaseContractDAO;
import com.ps.DAOs.SalesContractDAO;
import com.ps.DAOs.VehicleDAO;
import com.ps.Models.SalesContract;
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
                    SalesAndLeases.handleMenu(salesContractDAO, leaseContractDAO);
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
            System.out.println("~ (2) Update a Vehicle");
            System.out.println("~ (3) Remove a Vehicle");
            System.out.println("~ (0) Return to HOME menu");

            managingVehiclesInput = scanner.next().trim();

            switch (managingVehiclesInput) {

                case "1":
                    handleAddVehicle();
                    break;

                case "2":
                    handleUpdateVehicle();
                    break;

                case "3":
                    handleRemoveVehicle();
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

    public static void handleAddVehicle() {

        System.out.println("\n* Please enter in the VIN of the Vehicle:");
            int newVehicleVin;
                while(true) {
                    if (scanner.hasNextInt()) {
                        newVehicleVin = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the Year of the Vehicle:");
            int newVehicleYear;
                while(true) {
                    if (scanner.hasNextInt()) {
                        newVehicleYear = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the Make of the Vehicle:");
            String newVehicleMake;
                while (true) {
                    newVehicleMake = scanner.next().trim();
                    if (newVehicleMake.isEmpty()) {
                        System.out.println("* Please enter in a vehicle make.");
                    } else {
                        break;
                    }
                }

        String newVehicleMakeEntry = newVehicleMake.substring(0, 1).toUpperCase() + newVehicleMake.substring(1);

        System.out.println("* Please enter in the Model of the Vehicle:");
            String newVehicleModel;
                while (true) {
                    newVehicleModel = scanner.next().trim();
                    if (newVehicleModel.isEmpty()) {
                        System.out.println("* Please enter in a vehicle model.");
                    } else {
                        break;
                    }
                }
        String newVehicleModelEntry = newVehicleModel.substring(0,1).toUpperCase() + newVehicleModel.substring(1);

        System.out.println("* Please enter in the Type of the Vehicle:");
            String newVehicleType;
                while (true) {
                    newVehicleType = scanner.next().trim();
                    if (newVehicleType.isEmpty()) {
                        System.out.println("* Please enter in a vehicle type");
                    } else {
                        break;
                    }
                }
        String newVehicleTypeEntry = newVehicleType.substring(0,1).toUpperCase() + newVehicleType.substring(1);

        System.out.println("* Please enter in the Color of the Vehicle:");
            String newVehicleColor;
                while (true) {
                    newVehicleColor = scanner.next().trim();
                    if (newVehicleColor.matches(".*\\d.*") || newVehicleColor.isEmpty()) {
                        System.out.println("* Please enter in a color.");
                    } else {
                        break;
                    }
                }
        String newVehicleColorEntry = newVehicleColor.substring(0,1).toUpperCase() + newVehicleColor.substring(1);

        System.out.println("* Please enter in the Mileage of the Vehicle:");
            int newVehicleMileage;
                while(true) {
                    if (scanner.hasNextInt()) {
                        newVehicleMileage = scanner.nextInt();
                    break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the Price of the Vehicle:");
            double newVehiclePrice;
                while(true) {
                    if (scanner.hasNextDouble()) {
                        newVehiclePrice = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        Vehicle vehicle = new Vehicle(newVehicleVin, newVehicleYear, newVehicleMakeEntry, newVehicleModelEntry, newVehicleTypeEntry,
                newVehicleColorEntry, newVehicleMileage, newVehiclePrice
                );

        vehicleDAO.createVehicle(vehicle);
    }

    public static void handleUpdateVehicle() {

        System.out.println("\n* Please enter in the VIN of the Vehicle you would like to update.");
            int vin;
                while(true) {
                    if (scanner.hasNextInt()) {
                        vin = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        Vehicle vehicle = vehicleDAO.getOneVehicle(vin);

        System.out.println("\n* What would you like to update?\n");
        System.out.println("~ (1) Year\n~ (2) Make\n~ (3) Model\n~ (4) Vehicle Type\n~ (5) Color\n~ (6) Odometer\n~ (7) Price\n~ (8) Sold or Leased\n~ (0) Return to previous menu");
            int updateInput;
                while(true) {
                    if (scanner.hasNextInt()) {
                        updateInput = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        if(updateInput == 1) {

            System.out.println("\n* Please enter in the updated Year of the Vehicle:");
                int updatedYear;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            updatedYear = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }
            vehicle.setYear(updatedYear);

        } else if(updateInput == 2) {

            System.out.println("* Please enter in the updated Make of the Vehicle:");
                String updatedMake;
                    while (true) {
                        updatedMake = scanner.next().trim();
                        if (updatedMake.isEmpty()) {
                            System.out.println("* Please enter in a vehicle make.");
                        } else {
                            break;
                        }
                    }

            String updatedMakeEntry = updatedMake.substring(0, 1).toUpperCase() + updatedMake.substring(1);

            vehicle.setMake(updatedMakeEntry);

        } else if(updateInput == 3) {

            System.out.println("* Please enter in the updated Model of the Vehicle:");
                String updatedModel;
                    while (true) {
                        updatedModel = scanner.next().trim();
                        if (updatedModel.isEmpty()) {
                            System.out.println("* Please enter in a vehicle model.");
                        } else {
                            break;
                        }
                    }
            String updatedModelEntry = updatedModel.substring(0, 1).toUpperCase() + updatedModel.substring(1);

            vehicle.setModel(updatedModelEntry);

        } else if(updateInput == 4) {

            System.out.println("* Please enter in the updated Type of the Vehicle:");
                String updatedType;
                    while (true) {
                        updatedType = scanner.next().trim();
                        if (updatedType.isEmpty()) {
                            System.out.println("* Please enter in a vehicle type");
                        } else {
                            break;
                        }
                    }
            String updatedTypeEntry = updatedType.substring(0,1).toUpperCase() + updatedType.substring(1);

            vehicle.setVehicleType(updatedTypeEntry);

        } else if(updateInput == 5) {

            System.out.println("* Please enter in the updated Color of the Vehicle:");
                String updatedColor;
                    while (true) {
                        updatedColor = scanner.next().trim();
                        if (updatedColor.isEmpty()) {
                            System.out.println("* Please enter in a vehicle type");
                        } else {
                            break;
                        }
                    }
            String updatedColorEntry = updatedColor.substring(0,1).toUpperCase() + updatedColor.substring(1);

            vehicle.setColor(updatedColorEntry);

        } else if(updateInput == 6) {

            System.out.println("* Please enter in the Mileage of the Vehicle:");
                int updatedMileage;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            updatedMileage = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

            vehicle.setOdometer(updatedMileage);

        } else if(updateInput == 7) {

            System.out.println("* Please enter in the updated Price of the Vehicle:");
                double updatedPrice;
                    while(true) {
                        if (scanner.hasNextDouble()) {
                            updatedPrice = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

            vehicle.setPrice(updatedPrice);

        } else if(updateInput == 8) {

            System.out.println("* Please enter in the updated Availability of the Vehicle");
            System.out.println("'sold' | 'leased' | 'available'");
                String updatedAvailability;
                    while (true) {
                        updatedAvailability = scanner.next().trim();
                        if (updatedAvailability.isEmpty()) {
                            System.out.println("* Please enter in one of the listed options");
                        } else {
                            break;
                        }
                    }

            vehicle.setSoldOrLeased(updatedAvailability);

        } else if(updateInput == 0) {

            System.out.println("Returning to previous menu...");
            return;

        } else {
            System.out.println("\n* Please select one of the listed options\n");
        }

        vehicleDAO.updateVehicle(vin, vehicle);

    }

    public static void handleRemoveVehicle() {

        System.out.println("* Please enter in the VIN of the Vehicle you would like to remove");
            int removeVin = scanner.nextInt();

        System.out.println("* Are you sure you want to remove " + removeVin + "?");
            String confirmInput = scanner.next().toLowerCase().trim();
                if(confirmInput.equals("yes")) {
                    leaseContractDAO.deleteLeaseContract(removeVin);
                }

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
