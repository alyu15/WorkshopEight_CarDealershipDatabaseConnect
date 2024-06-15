package com.ps.UserInterfaces;

import java.util.Scanner;

import static com.ps.UserInterfaces.MainUserInterface.handleMisinputs;

public class SalesAndLeases {

    static Scanner scanner = new Scanner(System.in);

    public static void handleMenu(){

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
                    handleSalesContractsMenu();
                    break;

                case "2":
                    handleLeaseContractsMenu();
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

    public static void handleSalesContractsMenu() {

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
                    handleViewAllSalesContracts();
                    break;

                case "2":
                    handleSalesContractSearch();
                    break;

                case "3":
                    handleNewSalesContract();
                    break;

                case "4":
                    handleSalesContractUpdate();
                    break;

                case "5":
                    handleRemoveSalesContract();
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

    public static void handleLeaseContractsMenu() {

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
                    handleViewAllLeaseContracts();
                    break;

                case "2":
                    handleLeaseContractSearch();
                    break;

                case "3":
                    handleNewLeaseContract();
                    break;

                case "4":
                    handleLeaseContractUpdate();
                    break;

                case "5":
                    handleRemoveLeaseContract();
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

    public static void handleViewAllSalesContracts() {

    }

    public static void handleSalesContractSearch() {

    }

    public static void handleNewSalesContract() {

    }

    public static void handleSalesContractUpdate() {

    }

    public static void handleRemoveSalesContract() {

    }

    public static void handleViewAllLeaseContracts() {

    }

    public static void handleLeaseContractSearch() {

    }

    public static void handleNewLeaseContract() {

    }

    public static void handleLeaseContractUpdate() {

    }

    public static void handleRemoveLeaseContract() {

    }
}
