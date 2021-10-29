package exam.controller;

import exam.service.ImplementServices;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static ImplementServices implementServices = new ImplementServices();

    public static void displayMenu() {
        int choice = 0;
        do {
            System.out.println("--Product manager program--");
            System.out.println("Choose function by number");
            System.out.println("1. Add new product");
            System.out.println("2. Delete product");
            System.out.println("3. Display product list");
            System.out.println("4. Find product");
            System.out.println("5. Exit program");
            System.out.println("Enter a number to choose function");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong format. Please enter again: ");
            }

            switch (choice) {
                case 1:
                    implementServices.add();
                    break;
                case 2:
                    implementServices.delete();
                    break;
                case 3:
                    implementServices.displayProductList();
                    break;
                case 4:
                    implementServices.findProduct();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please choose a right number in the menu");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
