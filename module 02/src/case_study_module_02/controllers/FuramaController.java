package case_study_module_02.controllers;

import case_study_module_02.models.Booking;
import case_study_module_02.services.impl.*;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        int choiceOfMainFunction =0;
        do {
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter a number to choose the function: ");
            try {
                choiceOfMainFunction = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }

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
        } while (true);
    }

    public static void displayEmployeeManagement(){
        int choiceOfFunction1 = 0;
        EmployeeServicesImpl employeeServices = new EmployeeServicesImpl();
        do {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 1. Employee Management: ");
            try {
                choiceOfFunction1 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }

            switch (choiceOfFunction1){
                case 1:
                    employeeServices.display();
                    break;
                case 2:
                    employeeServices.add();
                    break;
                case 3:
                    employeeServices.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }

    public static void displayCustomerManagement(){
        int choiceOfFunction2 = 0;
        CustomerServicesImpl customerServices = new CustomerServicesImpl();
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 2. Customer Management: ");

            try {
                choiceOfFunction2 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
            switch (choiceOfFunction2){
                case 1:
                    customerServices.display();
                    break;
                case 2:
                    customerServices.add();
                    break;
                case 3:
                    customerServices.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }

    public static void displayFacilityManagement(){
        FacilityServicesImpl facilityServices = new FacilityServicesImpl();
        int choiceOfFunction3 = 0;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 3. Facility Management: ");

            try {
                choiceOfFunction3 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
            switch (choiceOfFunction3){
                case 1:
                    facilityServices.display();
                    break;
                case 2:
                    addFacilityServices();
                    break;
                case 3:
                    facilityServices.displayListMaintenance();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }

    public static void addFacilityServices(){
        FacilityServicesImpl facilityServices = new FacilityServicesImpl();
        int choice =0 ;
        do {
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new room");
            System.out.println("Enter a choice ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
            switch (choice){
                case 1:
                    facilityServices.addVilla();
                    displayFacilityManagement();
                    break;
                case 2:
                    facilityServices.addHouse();
                    displayFacilityManagement();
                    break;
                case 3:
                    facilityServices.addRoom();
                    displayFacilityManagement();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }

    public static void displayBookingManagement(){
        BookingServicesImpl bookingServices = new BookingServicesImpl();
        ContractServicesImpl contractServices = new ContractServicesImpl();
        int choiceOfFunction4 = 0;
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 4. Booking  Management: ");

            try {
                choiceOfFunction4 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
            switch (choiceOfFunction4){
                case 1:
                    bookingServices.add();
                    break;
                case 2:
                    bookingServices.display();
                    break;
                case 3:
                    contractServices.add();
                    break;
                case 4:
                    contractServices.display();
                    break;
                case 5:
                    contractServices.edit();
                    break;
                case 6:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }

    public static void displayPromotionManagement (){
        int choiceOfFunction5 = 0;
        PromotionServicesImpl promotionServices = new PromotionServicesImpl();
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println();
            System.out.println("Enter a number to choose a function in 5. Promotion Management: ");
            
            try {
                choiceOfFunction5 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
            switch (choiceOfFunction5){
                case 1:
                    promotionServices.display();
                    break;
                case 2:
                    promotionServices.displayCustomersGetVoucher();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Please choose a right number in the menu ");
            }
        } while (true);
    }


}
