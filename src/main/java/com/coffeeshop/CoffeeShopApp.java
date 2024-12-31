package com.coffeeshop;

import java.util.Scanner;

public class CoffeeShopApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Coffee Shop Management System!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Discounts");
            System.out.println("2. View Drinks");
            System.out.println("3. Manage Orders");
            System.out.println("4. View Staff Schedule");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> manageDiscounts();
                case 2 -> viewDrinks();
                case 3 -> manageOrders();
                case 4 -> viewStaffSchedule();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageDiscounts() {
        System.out.println("\n--- Manage Discounts ---");
        System.out.println("1. View Minimum Discount");
        System.out.println("2. View Maximum Discount");
        System.out.println("3. View Average Discount");
        System.out.println("4. View Customers with Minimum Discount");
        System.out.println("5. View Customers with Maximum Discount");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> DiscountQueries.getMinDiscount();
            case 2 -> DiscountQueries.getMaxDiscount();
            case 3 -> DiscountQueries.getAverageDiscount();
            case 4 -> DiscountQueries.getCustomersWithMinDiscount();
            case 5 -> DiscountQueries.getCustomersWithMaxDiscount();
            case 6 -> System.out.println("Returning to Main Menu...");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void viewDrinks() {
        System.out.println("\n--- View Drinks ---");
        DrinksOperations.listDrinks();
    }

    private static void manageOrders() {
        System.out.println("\n--- Manage Orders ---");
        System.out.println("This functionality is under construction.");
        // Add operations for managing orders if necessary
    }

    private static void viewStaffSchedule() {
        System.out.println("\n--- View Staff Schedule ---");
        System.out.println("1. View All Schedules");
        System.out.println("2. View Schedule for Specific Staff Member");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> ScheduleOperations.listSchedules();
            case 2 -> {
                System.out.print("Enter Staff ID: ");
                int staffId = scanner.nextInt();
                ScheduleOperations.listSchedulesForStaff(staffId);
            }
            case 3 -> System.out.println("Returning to Main Menu...");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }
}