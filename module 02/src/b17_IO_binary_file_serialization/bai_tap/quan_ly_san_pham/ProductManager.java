package b17_IO_binary_file_serialization.bai_tap.quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static List<Product> productList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        productList = new ArrayList<>();
        productList.add(new Product("P001", "Iphone", "Apple", 20000, "new"));
        productList.add(new Product("P002", "Galaxy", "Samsung", 25000, "old"));
        productList.add(new Product("P003", "Redmi", "Xiaomi", 15000, "sealed"));

    }

    public static List<Product> readFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            products = (List<Product>) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeFile(String path, List<Product> productList) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(productList);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu() {
        int choice = -1;
        do {
            System.out.printf("Menu: \n" +
                    "1. Display product list \n" +
                    "2. Add new product \n" +
                    "3. Find product by code \n" +
                    "4. Exit \n ");
            System.out.println("Enter a choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    System.out.println(findProduct());;
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayProductList() {

        writeFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b17_IO_binary_file_serialization\\bai_tap\\quan_ly_san_pham\\productFile", productList);

        List<Product> productList1 = readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b17_IO_binary_file_serialization\\bai_tap\\quan_ly_san_pham\\productFile");
        for (Product product : productList1){
            System.out.println(product);
        }
    }

    public static void addProduct() {
        String newCode;
        scanner.skip("\\R");
        do {
            System.out.println("Enter the new code: ");
            newCode = scanner.nextLine();
        } while (!checkCodeProduct(newCode));
        System.out.println("enter the new name of product:");
        String name = scanner.nextLine();
        System.out.println("enter the new brand of product:");
        String brand = scanner.nextLine();
        System.out.println("enter the new price of product:");
        double price = scanner.nextDouble();
        scanner.skip("\\R");
        System.out.println("enter the new description of product:");
        String description = scanner.nextLine();
        
        productList.add(new Product(newCode, name, brand, price, description));
        displayProductList();

    }

    public static String findProduct() {
        String code;
        scanner.skip("\\R");
        do {
            System.out.println("Enter the code to find product: ");
            code = scanner.nextLine();
        } while (!checkCodeToFind(code));
         for (Product product: productList){
             if (code.equals(product.getCode())){
                 return product.toString();
             }
         }
        return "Product is not existed";
    }

    public static boolean checkCodeProduct (String code){

        if (code == null || code.equals("")){
            System.out.println("you must enter a new code");
            return false;
        }
        for (Product product : productList){
            if (code.equals(product.getCode())){
                System.out.println("Code already existed");
                return false;
            }
        }
        return true;
    }
    public static boolean checkCodeToFind (String code){
        if (code == null || code.equals("")){
            System.out.println("you must enter a code");
            return false;
        }
        for (Product product : productList){
            if (code.equals(product.getCode())){
                return true;
            }
        }
        return false;
    }
}
