package case_study_module_02.controllers;

import case_study_module_02.services.impl.EmployeeServicesImpl;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choiceOfMainFunction;
        do {
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter a number to choose the function: ");
            choiceOfMainFunction = Integer.parseInt(scanner.nextLine());

            switch (choiceOfMainFunction) {
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    displayFacilityManagement();
                    break;
                case 4:
                    displayBookingManagement();
                    break;
                case 5:
                    displayPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);/*choiceOfMainFunction != 6*/
    }

    public static void displayEmployeeManagement(){
        int choiceOfFunction1;
        Scanner scanner = new Scanner(System.in);
        EmployeeServicesImpl employeeServices = new EmployeeServicesImpl();
        do {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 1. Employee Management: ");
            choiceOfFunction1 = Integer.parseInt(scanner.nextLine());

            switch (choiceOfFunction1){
                case 1:
                    employeeServices.display();
                    break;
                case 2:
                    employeeServices.add();
                    break;
                case 3:
                    employeeServices.edit();
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (choiceOfFunction1 != 4); /*choiceOfFunction1 != 4*/
    }

    public static void displayCustomerManagement(){
        int choiceOfFunction2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 2. Customer Management: ");
            choiceOfFunction2 = scanner.nextInt();
        } while (choiceOfFunction2 != 4);/*choiceOfFunction2 != 4*/
    }

    public static void displayFacilityManagement(){
        int choiceOfFunction3;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 3. Facility Management: ");
            choiceOfFunction3 = scanner.nextInt();
        } while (choiceOfFunction3 != 4);/*choiceOfFunction3 != 4*/
    }

    public static void displayBookingManagement(){
        int choiceOfFunction4;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 4. Booking  Management: ");
            choiceOfFunction4 = scanner.nextInt();
        } while (choiceOfFunction4 != 6); /*choiceOfFunction4 != 6*/
    }

    public static void displayPromotionManagement (){
        int choiceOfFunction5;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 5. Promotion Management: ");
            choiceOfFunction5 = scanner.nextInt();
        } while (choiceOfFunction5 != 3);/*choiceOfFunction5 != 3*/
    }


}
