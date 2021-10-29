package exam.service;

import case_study_module_02.utils.RegexData;
import exam.controller.Menu;
import exam.model.ExportProduct;
import exam.model.ImportProduct;
import exam.model.Product;
import exam.util.NotFoundProductException;
import exam.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ImplementServices implements Services {
    public static final String MONEY_REGEX = "^[1-9]|([1][0-9])|\\d{3,}$";
    Menu menu = new Menu();
    private static List<Product> productList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        productList = new ArrayList<>();
        productList.add(new ImportProduct(1, "SP00001", "Giay Adidas", 1000000, 10, "USA", 800000, "Da Nang", 150000));
        productList.add(new ExportProduct(2, "SP00006", "Ao dai", 1000000, 50, "Viet Nam", 2000000, "Singapore"));
        ReadAndWrite.write(productList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
    }

    @Override
    public void add() {
        int choice = -1;
        do {
            System.out.println("Choose a type of product to add");
            System.out.println("1. Import product");
            System.out.println("2. Export product");
            System.out.println("Enter a choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("wrong format. enter again ");
            }
            switch (choice) {
                case 1:
                    addImportProduct();
                    break;
                case 2:
                    addExportProduct();
                    break;
                default:  System.out.println("please enter a right choice");
            }
        } while (true);
    }

    public void addImportProduct() {

        int id = increaseId();

        System.out.println("enter product code");
        String code = scanner.nextLine();

        System.out.println("enter product name");
        String name = scanner.nextLine();

        System.out.println("enter product price");
        int price = Integer.parseInt(inputAmount());

        System.out.println("enter product quantity");
        int quantity = Integer.parseInt(inputAmount());

        System.out.println("enter product manufacture");
        String manufacture = scanner.nextLine();

        System.out.println("enter import price");
        int importPrice = Integer.parseInt(inputAmount());

        System.out.println("enter product province importing product");
        String province = scanner.nextLine();

        System.out.println("enter import tax");
        int importTax = Integer.parseInt(inputAmount());

        ImportProduct importProduct = new ImportProduct(id, code, name, price, quantity, manufacture, importPrice, province, importTax);
        productList.add(importProduct);
        ReadAndWrite.write(productList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
        System.out.println("add new product successful");
        menu.displayMenu();
    }

    public void addExportProduct() {

        int id = increaseId();

        System.out.println("enter product code");
        String code = scanner.nextLine();

        System.out.println("enter product name");
        String name = scanner.nextLine();

        System.out.println("enter product price");
        int price = Integer.parseInt(inputAmount());


        System.out.println("enter product quantity");
        int quantity = Integer.parseInt(inputAmount());

        System.out.println("enter product manufacture");
        String manufacture = scanner.nextLine();

        System.out.println("enter export price");
        int exportPrice = Integer.parseInt(inputAmount());


        System.out.println("enter country importing product");
        String country = scanner.nextLine();


        ExportProduct exportProduct = new ExportProduct(id, code, name, price, quantity, manufacture, exportPrice, country);
        productList.add(exportProduct);
        ReadAndWrite.write(productList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
        System.out.println("add new product successful");
        menu.displayMenu();

    }

    @Override
    public void delete() {
        System.out.println("enter product code to delete");
        String code = "";
        boolean check = true;
         do {
               try{
                   code = scanner.nextLine();
                   if (!checkCode(code)){
                       throw new NotFoundProductException("product does not exist");
                   }
               }catch (Exception e){
                   e.printStackTrace();
                   System.out.println("enter again");
               }
           } while (!check);

        int choice = 0;
        do {
            System.out.println("are you sure for deleting this product");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Enter a number to choose");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    Iterator<Product> iterator = productList.iterator();
                    while (iterator.hasNext()){
                        Product product = iterator.next();
                        if (code.equals(product.getProductCode())){
                            productList.remove(product);
                        }
                    }
                    System.out.println("delete success");
                    ReadAndWrite.write(productList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
                    displayProductList();
                    menu.displayMenu();
                    break;
                case 2:
                    menu.displayMenu();
                    break;
                default:
                    System.out.println("please enter a right choice");
            }
        } while (true);
    }

    public boolean checkCode(String code) {
        for (Product product : productList) {
            if (code.equals(product.getProductCode())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkName(String name) {
        for (Product product : productList) {
            if (name.equals(product.getProductCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayProductList() {
        System.out.println("Product list include: ");
        productList = (List<Product>) ReadAndWrite.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void findProduct() {
        productList = (List<Product>) ReadAndWrite.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\exam\\data\\product.csv");
        System.out.println("Enter product code or product name to find");
        String input = scanner.nextLine();
        System.out.println("product that  can find in product list include");
        for (Product product : productList) {
            if (input.equals(product.getProductCode()) || input.equals(product.getProductName())) {
                System.out.println(product.toString());
            }
        }
        if (!checkCode(input) || !checkName(input)){
                System.out.println("product does not exist");
        }
    }

    private String inputAmount (){
        System.out.println("Enter a number: ");
        return RegexData.regexStr(scanner.nextLine(), MONEY_REGEX, "Wrong format. Amount must greater than 0");
    }

    public int increaseId(){
       int id =  productList.size() + 1;
       return id;
    }
}
