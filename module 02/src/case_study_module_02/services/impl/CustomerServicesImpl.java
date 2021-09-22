package case_study_module_02.services.impl;

import case_study_module_02.models.Customer;
import case_study_module_02.services.CustomerServices;
import case_study_module_02.utils.ReadAndWriteFile;
import case_study_module_02.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServicesImpl implements CustomerServices {
    private static List<Customer> customerList = new LinkedList<>();

    public static final String REGEX_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    private static Scanner scanner = new Scanner(System.in);
    static {
        Customer customer1 = new Customer("Le van A", "01/02/1999", "nam", 23114545, "0984123123", "aaa@gamil.com","KH01", "Gold", "Danang");
        Customer customer2 = new Customer("Le thi B", "01/02/1999", "nu", 23113344, "0984123123", "bbb@gamil.com","KH02", "Diamond", "Hanoi");
        Customer customer3 = new Customer("Le van C", "01/02/1999", "nam", 23114545, "0984123123", "ccc@gamil.com","KH03", "Silver", "HCM");
        Customer customer4 = new Customer("Le van D", "02/01/1990", "nam", 23114545, "0984123123", "ccc@gamil.com","KH04", "Silver", "HCM");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        ReadAndWriteFile.write(customerList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\customer.csv");
    }
    @Override
    public void display() {
        /*1.	Display list customers*/

        customerList = (List<Customer>) ReadAndWriteFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\customer.csv");
        for (Customer customer: customerList){
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() {
        /*2.	Add new customer*/

        System.out.println("Enter customer's name: ");
        String name = scanner.nextLine();

        String date = inputAge();

        System.out.println("Enter customer's sex: ");
        String sex = scanner.nextLine();

        System.out.println("Enter customer's id number: ");
        int id = 0;
        try {
            id =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter customer's phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter customer's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter customer's code: ");
        String code = scanner.nextLine();

        System.out.println("Enter customer's type: ");
        String type = scanner.nextLine();

        System.out.println("Enter customer's address: ");
        String address = scanner.nextLine();

        Customer newCustomer = new Customer(name, date, sex, id, phoneNumber, email, code, type, address);
        customerList.add(newCustomer);
        ReadAndWriteFile.write(customerList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\customer.csv");
        System.out.println("Successfully added new customer ");
    }

    @Override
    public void edit() {
        /*3.	Edit customer*/
        String code;
        int index = 0;
        do {
            System.out.println("enter the code of customer whom you want to edit: ");
            code = scanner.nextLine();
        } while (!checkCode(code));

        for (Customer customer: customerList){
            if ((customer.getCustomerCode()).equals(code)){
                index = customerList.indexOf(customer);
            }
        }

        System.out.println("Enter customer's name: ");
        String name = scanner.nextLine();

        String date = inputAge();

        System.out.println("Enter customer's sex: ");
        String sex = scanner.nextLine();

        System.out.println("Enter customer's id number: ");
        int id = 0;
        try {
            id =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter customer's phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter customer's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter customer's type: ");
        String type = scanner.nextLine();

        System.out.println("Enter customer's address: ");
        String address = scanner.nextLine();

        Customer newCustomer = new Customer(name, date, sex, id, phoneNumber, email, code, type, address);
        for (Customer customer : customerList){
            if ((customer.getCustomerCode()).equals(code)){
                customerList.set(index, newCustomer);
                ReadAndWriteFile.write(customerList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\customer.csv");
            }
        }
        System.out.println("Edit success");
    }

    private String inputAge (){
        System.out.println("Enter date of birth");
        return RegexData.regexAge(scanner.nextLine(), REGEX_DATE);
    }

    public boolean checkCode(String code){
        for (Customer customer: customerList){
            if ((customer.getCustomerCode()).equals(code)){
                return true;
            }
        }
        return false;
    }

    public List<Customer> customerData(){
        return customerList;
    }
}
