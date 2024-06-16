package com.ps.UserInterfaces;

import com.ps.DAOs.LeaseContractDAO;
import com.ps.DAOs.SalesContractDAO;
import com.ps.Models.LeaseContract;
import com.ps.Models.SalesContract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.ps.UserInterfaces.MainUserInterface.handleMisinputs;

public class SalesAndLeases {

    static Scanner scanner = new Scanner(System.in);

    public static void handleMenu(SalesContractDAO salesContractDAO, LeaseContractDAO leaseContractDAO){

        String salesAndLeasesMenuInput;

        do {

            System.out.println("*************************************************************************************************************************************************");
            System.out.println("===========================================  Manage Sales and Leases  ===============================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) Sales Contracts");
            System.out.println("~ (2) Lease Contracts");
            System.out.println("~ (0) Return to HOME menu");

            salesAndLeasesMenuInput = scanner.next().trim();

            switch (salesAndLeasesMenuInput) {
                case "1":
                    handleSalesContractsMenu(salesContractDAO);
                    break;

                case "2":
                    handleLeaseContractsMenu(leaseContractDAO);
                    break;

                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    handleMisinputs();
                    break;
            }

        } while (!salesAndLeasesMenuInput.equals("0"));
    }

    public static void handleSalesContractsMenu(SalesContractDAO salesContractDAO) {

        String salesMenuInput;

        do {
            System.out.println("*************************************************************************************************************************************************");
            System.out.println("===========================================  Sales Contracts  ===============================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View all Sales Contracts");
            System.out.println("~ (2) Search for a Sales Contract");
            System.out.println("~ (3) Create a new Sales Contract");
            System.out.println("~ (4) Update an existing Sales Contract");
            System.out.println("~ (5) Remove a Sales Contract");
            System.out.println("~ (0) Return to HOME menu");

            salesMenuInput = scanner.next().trim();

            switch (salesMenuInput) {
                case "1":
                    handleViewAllSalesContracts(salesContractDAO);
                    break;

                case "2":
                    handleSalesContractSearch(salesContractDAO);
                    break;

                case "3":
                    handleNewSalesContract(salesContractDAO);
                    break;

                case "4":
                    handleSalesContractUpdate(salesContractDAO);
                    break;

                case "5":
                    handleRemoveSalesContract(salesContractDAO);
                    break;

                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    handleMisinputs();
                    break;
            }

        } while (!salesMenuInput.equals("0"));

    }

    public static void handleLeaseContractsMenu(LeaseContractDAO leaseContractDAO) {

        String leaseMenuInput;

        do {
            System.out.println("*************************************************************************************************************************************************");
            System.out.println("===========================================  Sales Contracts  ===============================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View all Lease Contracts");
            System.out.println("~ (2) Search for a Lease Contract");
            System.out.println("~ (3) Create a new Lease Contract");
            System.out.println("~ (4) Update an existing Lease Contract");
            System.out.println("~ (5) Delete a Lease Contract");
            System.out.println("~ (0) Return to HOME menu");

            leaseMenuInput = scanner.next().trim();

            switch (leaseMenuInput) {

                case "1":
                    handleViewAllLeaseContracts(leaseContractDAO);
                    break;

                case "2":
                    handleLeaseContractSearch(leaseContractDAO);
                    break;

                case "3":
                    handleNewLeaseContract(leaseContractDAO);
                    break;

                case "4":
                    handleLeaseContractUpdate(leaseContractDAO);
                    break;

                case "5":
                    handleRemoveLeaseContract(leaseContractDAO);
                    break;

                case "0":
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    handleMisinputs();
                    break;
            }

        } while (!leaseMenuInput.equals("0"));

    }

    public static void handleViewAllSalesContracts(SalesContractDAO salesContractDAO) {

        System.out.println("\n====================================================== View All Sales Contracts =========================================================");
        List<SalesContract> allSalesContracts = salesContractDAO.getAllSalesContracts();
        displaySalesContracts(allSalesContracts);

    }

    public static void handleSalesContractSearch(SalesContractDAO salesContractDAO) {

        System.out.println("\n* Please enter in the contract id of the Lease Contract you are searching for");
            int salesContractSearch;
                while(true) {
                    if (scanner.hasNextInt()) {
                        salesContractSearch = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        salesContractDAO.getOneSalesContract(salesContractSearch);

    }

    public static void handleNewSalesContract(SalesContractDAO salesContractDAO) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String formattedDate = currentDate.format(dateFormatter);

        System.out.println("\n* Please enter in the First Name of the Customer.");
            String firstName;
                while (true) {
                    firstName = scanner.next().toLowerCase().trim();
                    if (firstName.isEmpty()) {
                        System.out.println("* Please enter in a name.");
                    } else {
                        break;
                    }
                }
                String firstNameEntry = firstName.substring(0,1).toUpperCase() + firstName.substring(1);

        System.out.println("\n* Please enter in the Last Name of the Customer.");
            String lastName;
                while (true) {
                    lastName = scanner.next().toLowerCase().trim();
                    if (lastName.isEmpty()) {
                        System.out.println("* Please enter in a name.");
                    } else {
                        break;
                    }
                }
            String lastNameEntry = lastName.substring(0,1).toUpperCase() + lastName.substring(1);

        String customerName = firstNameEntry + " " + lastNameEntry;

        System.out.println("\n* Please enter in the Email of the Customer");
            String customerEmail;
                while (true) {
                    customerEmail = scanner.next().toLowerCase().trim();
                    if (customerEmail.isEmpty()) {
                        System.out.println("* Please enter in an email.");
                    } else {
                        break;
                    }
                }

        System.out.println("\n* Please enter in the VIN");
            int vin;
                while(true) {
                    if (scanner.hasNextInt()) {
                        vin = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a VIN.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Please enter in the updated Sales Tax Amount");
            float salesTaxAmount;
                while(true) {
                    if (scanner.hasNextFloat()) {
                        salesTaxAmount = scanner.nextFloat();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Please enter in the Recording Fee amount");
            int recordingFee;
                while(true) {
                    if (scanner.hasNextInt()) {
                        recordingFee = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Please enter in the Processing Fee amount");
            int processingFee;
                while(true) {
                    if (scanner.hasNextInt()) {
                        processingFee = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Please enter in 'yes' or 'no' for the Customer's Financing Choice\n");
            String financeChoice;
                while (true) {
                    financeChoice = scanner.next().toLowerCase().trim();
                    if (financeChoice.isEmpty()) {
                        System.out.println("* Please enter in a finance choice.");
                    } else {
                        break;
                    }
                }

        SalesContract salesContract = new SalesContract(formattedDate, customerName, customerEmail, vin, salesTaxAmount,
                recordingFee, processingFee, financeChoice);

        salesContractDAO.createSalesContract(salesContract);

    }

    public static void handleSalesContractUpdate(SalesContractDAO salesContractDAO) {

        System.out.println("\n* Please enter in the contract id of the Sales Contract you would like to update");
            int updateSalesId;
                while(true) {
                    if (scanner.hasNextInt()) {
                        updateSalesId = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        SalesContract salesContract = salesContractDAO.getOneSalesContract(updateSalesId);

        System.out.println("\n* What would you like to update?\n");
        System.out.println("~ (1) Customer Name\n~ (2) Customer Email\n~ (3) VIN\n~ (4) Sales Tax Amount\n~ (5) Processing Fee\n~ (6) Finance Choice\n~ (0) Return to previous menu");
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

            System.out.println("\n* Please enter in the updated Customer First Name");
                String firstName;
                    while (true) {
                        firstName = scanner.next().toLowerCase().trim();
                        if (firstName.isEmpty()) {
                            System.out.println("* Please enter in a name.");
                        } else {
                            break;
                        }
                    }
                String firstNameEntry = firstName.substring(0,1).toUpperCase() + firstName.substring(1);

            System.out.println("\n* Please enter in the updated Customer Last Name");
                String lastName;
                    while (true) {
                        lastName = scanner.next().toLowerCase().trim();
                        if (lastName.isEmpty()) {
                            System.out.println("* Please enter in a name.");
                        } else {
                            break;
                        }
                    }
                String lastNameEntry = lastName.substring(0,1).toUpperCase() + lastName.substring(1);

            String updatedName = firstNameEntry + " " + lastNameEntry;
            salesContract.setCustomerName(updatedName);

        } else if(updateInput == 2) {

            System.out.println("\n* Please enter in the updated Customer Email");
                String updatedEmail;
                    while (true) {
                        updatedEmail = scanner.next().toLowerCase().trim();
                        if (updatedEmail.isEmpty()) {
                            System.out.println("* Please enter in an email.");
                        } else {
                            break;
                        }
                    }

            salesContract.setCustomerEmail(updatedEmail);

        } else if(updateInput == 3) {

            System.out.println("\n* Please enter in the updated VIN");
                int updatedVin;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            updatedVin = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("* Please enter in a VIN.");
                            scanner.next();
                        }
                    }

            salesContract.setVin(updatedVin);

        } else if(updateInput == 4) {

            System.out.println("\n* Please enter in the updated Sales Tax Amount");
                float updatedSalesTaxAmount;
                    while(true) {
                        if (scanner.hasNextFloat()) {
                            updatedSalesTaxAmount = scanner.nextFloat();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

            salesContract.setSalesTaxAmount(updatedSalesTaxAmount);

        } else if(updateInput == 5) {

            System.out.println("\n* Please enter in the updated Processing Fee amount");
                int updatedProcessingFee;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            updatedProcessingFee = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

            salesContract.setProcessingFee(updatedProcessingFee);

        } else if(updateInput == 6) {

            System.out.println("\n* Please enter in the updated Financing Choice\n");
                String updatedFinanceChoice;
                    while (true) {
                        updatedFinanceChoice = scanner.next().toLowerCase().trim();
                        if (updatedFinanceChoice.isEmpty()) {
                            System.out.println("* Please enter in a finance choice.");
                        } else {
                            break;
                        }
                    }

            salesContract.setFinanceChoice(updatedFinanceChoice);

        } else if(updateInput == 0) {

            System.out.println("Returning to previous menu...");
            return;

        } else {
            System.out.println("\n* Please select one of the listed options\n");
        }

        salesContractDAO.updateSalesContract(updateSalesId, salesContract);

    }

    public static void handleRemoveSalesContract(SalesContractDAO salesContractDAO) {

        System.out.println("\n* Please enter in the contract id of the Sales Contract you would like to remove");
            int removeSalesId;
                while(true) {
                    if (scanner.hasNextInt()) {
                        removeSalesId = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Are you sure you want to remove " + removeSalesId + "?");
            String confirmInput = scanner.next().toLowerCase().trim();
                if(confirmInput.equals("yes")) {
                salesContractDAO.deleteSalesContract(removeSalesId);
                }
    }

    public static void handleViewAllLeaseContracts(LeaseContractDAO leaseContractDAO) {

        List<LeaseContract> leaseContracts = leaseContractDAO.getAllLeaseContracts();
        displayLeaseContracts(leaseContracts);

    }

    public static void handleLeaseContractSearch(LeaseContractDAO leaseContractDAO) {

        System.out.println("* Please enter in the contract id of the Lease Contract you are searching for");
            int searchLeaseId;
                while(true) {
                    if (scanner.hasNextInt()) {
                        searchLeaseId = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        leaseContractDAO.getOneLeaseContract(searchLeaseId);

    }

    public static void handleNewLeaseContract(LeaseContractDAO leaseContractDAO) {

        LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            String formattedDate = currentDate.format(dateFormatter);

        System.out.println("\n* Please enter in the First Name of the Customer.");
            String firstName;
                while (true) {
                    firstName = scanner.next().toLowerCase().trim();
                    if (firstName.isEmpty()) {
                        System.out.println("* Please enter in a name.");
                    } else {
                        break;
                    }
                }
            String firstNameEntry = firstName.substring(0,1).toUpperCase() + firstName.substring(1);

        System.out.println("\n* Please enter in the Last Name of the Customer.");
            String lastName;
                while (true) {
                    lastName = scanner.next().toLowerCase().trim();
                    if (lastName.isEmpty()) {
                        System.out.println("* Please enter in a name.");
                    } else {
                        break;
                    }
                }
            String lastNameEntry = lastName.substring(0,1).toUpperCase() + lastName.substring(1);

        String customerName = firstNameEntry + " " + lastNameEntry;

        System.out.println("\n* Please enter in the Email of the Customer");
            String customerEmail;
                while (true) {
                    customerEmail = scanner.next().toLowerCase().trim();
                    if (customerEmail.isEmpty()) {
                        System.out.println("* Please enter in an email.");
                    } else {
                        break;
                    }
                }

        System.out.println("\n* Please enter in the VIN");
            int vin;
                while(true) {
                    if (scanner.hasNextInt()) {
                        vin = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a VIN.");
                        scanner.next();
                    }
                }

        System.out.println("* Please enter in the Lease Fee amount.");
            float leaseFee;
                while(true) {
                        if (scanner.hasNextFloat()) {
                            leaseFee = scanner.nextFloat();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

        System.out.println("* Please enter in the Expected Ending Value amount");
            double expectedEndingValue;
                while(true) {
                        if (scanner.hasNextDouble()) {
                            expectedEndingValue = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }

        LeaseContract leaseContract = new LeaseContract(formattedDate, customerName, customerEmail, vin, leaseFee, expectedEndingValue);

        leaseContractDAO.createLeaseContract(leaseContract);

    }

    public static void handleLeaseContractUpdate(LeaseContractDAO leaseContractDAO) {

        System.out.println("* Please enter in the contract id of the Lease Contract you would like to update");
            int updateLeaseId;
                while(true) {
                    if (scanner.hasNextInt()) {
                        updateLeaseId = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        LeaseContract leaseContract = leaseContractDAO.getOneLeaseContract(updateLeaseId);

        System.out.println("* What would you like to update?\n");
        System.out.println("~ (1) Customer Name\n~ (2) Customer Email\n~ (3) Vin\n~ (4) Lease Fee\n~ (5) Expected Ending Value\n~ (0) Return to previous menu");
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
            System.out.println("* Please enter in the updated Customer First Name");
                String firstName;
                    while (true) {
                        firstName = scanner.next().toLowerCase().trim();
                        if (firstName.isEmpty()) {
                            System.out.println("* Please enter in a name.");
                        } else {
                            break;
                        }
                    }
                String firstNameEntry = firstName.substring(0,1).toUpperCase() + firstName.substring(1);

            System.out.println("* Please enter in the updated Customer Last Name");
                String lastName;
                    while (true) {
                        lastName = scanner.next().toLowerCase().trim();
                        if (lastName.isEmpty()) {
                            System.out.println("* Please enter in a name.");
                        } else {
                            break;
                        }
                    }
                String lastNameEntry = lastName.substring(0,1).toUpperCase() + lastName.substring(1);

            String updatedName = firstNameEntry + " " + lastNameEntry;
            leaseContract.setCustomerName(updatedName);

        } else if(updateInput == 2) {

            System.out.println("* Please enter in the updated Customer Email");
                String updatedEmail;
                    while (true) {
                        updatedEmail = scanner.next().trim();
                        if (updatedEmail.isEmpty()) {
                            System.out.println("* Please enter in an email.");
                        } else {
                            break;
                        }
                    }
            leaseContract.setCustomerEmail(updatedEmail);

        } else if(updateInput == 3) {

            System.out.println("* Please enter in the updated VIN");
                int updatedVin;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            updatedVin = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }
            leaseContract.setVin(updatedVin);

        } else if(updateInput == 4) {

            System.out.println("* Please enter in the updated Lease Fee");
                float updatedLeaseFee;
                    while(true) {
                        if (scanner.hasNextFloat()) {
                            updatedLeaseFee = scanner.nextFloat();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }
            leaseContract.setLeaseFee(updatedLeaseFee);

        } else if(updateInput == 5) {

            System.out.println("* Please enter in the updated Expected Ending Value");
                double updatedEndingValue;
                    while(true) {
                        if (scanner.hasNextDouble()) {
                            updatedEndingValue = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("* Please enter in a number.");
                            scanner.next();
                        }
                    }
            leaseContract.setExpectedEndingValue(updatedEndingValue);

        } else if(updateInput == 0) {

            System.out.println("Returning to previous menu...");
            return;

        } else {
            System.out.println("Please select one of the listed options to update");
        }

        leaseContractDAO.updateLeaseContract(updateLeaseId, leaseContract);
    }

    public static void handleRemoveLeaseContract(LeaseContractDAO leaseContractDAO) {

        System.out.println("\n* Please enter in the contract id of the Lease Contract you would like to remove");
            int removeLeaseId;
                while(true) {
                    if (scanner.hasNextInt()) {
                        removeLeaseId = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("* Please enter in a number.");
                        scanner.next();
                    }
                }

        System.out.println("\n* Are you sure you want to remove " + removeLeaseId + "?");
            String confirmInput = scanner.next().toLowerCase().trim();
                if(confirmInput.equals("yes")) {
                    leaseContractDAO.deleteLeaseContract(removeLeaseId);
                }
    }

    public static void displaySalesContracts(List<SalesContract> salesContracts) {

        System.out.println("\n**********************************************  Sales Contracts  ***************************************************");
        System.out.println("ID     Date Signed       Name               Email              VIN        Sales Tax Amount     Recording Fee  Processing Fee       Financing");

        for (SalesContract salesContract : salesContracts) {
            System.out.printf("~ %d  %-10s  %-30s  %-30s  %-5d  %-8.2f  %-4d  %-3d  %-3s\n",
                    salesContract.getContractId(),
                    salesContract.getContractDate(),
                    salesContract.getCustomerName(),
                    salesContract.getCustomerEmail(),
                    salesContract.getVin(),

                    salesContract.getSalesTaxAmount(),
                    salesContract.getRecordingFee(),
                    salesContract.getProcessingFee(),
                    salesContract.getFinanceChoice()
            );
        }
        if(salesContracts.isEmpty()) {
            System.out.println("\n           ******************************** No contracts found ********************************");
        }
    }

    public static void displayLeaseContracts(List<LeaseContract> leaseContracts) {

        System.out.println("\n**********************************************  Sales Contracts  ***************************************************");
        System.out.println("ID     Date Signed       Name               Email              VIN        Lease Fee     Expected Ending Value");

        for (LeaseContract leaseContract: leaseContracts) {
            System.out.printf("~ %d  %-10s  %-30s  %-30s  %-5d  %-8.2f  %-4d  %-3d  %-3s\n",
                    leaseContract.getContractId(),
                    leaseContract.getContractDate(),
                    leaseContract.getCustomerName(),
                    leaseContract.getCustomerEmail(),
                    leaseContract.getVin(),

                    leaseContract.getLeaseFee(),
                    leaseContract.getExpectedEndingValue()
            );
        }

        if(leaseContracts.isEmpty()) {
            System.out.println("\n           ******************************** No contracts found ********************************");
        }
    }
}
