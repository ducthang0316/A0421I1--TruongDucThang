package case_study_module_02.services.impl;

import case_study_module_02.models.Booking;
import case_study_module_02.models.Customer;
import case_study_module_02.services.PromotionServices;

import java.util.*;

public class PromotionServicesImpl implements PromotionServices {

    static Stack<String> voucherStack = new Stack<>();
    static Stack<Booking> bookingStack = new Stack<>();

    static Scanner scanner = new Scanner(System.in);

    static CustomerServicesImpl customerServices = new CustomerServicesImpl();
    static List<Customer> customerList = customerServices.customerData();

    static BookingServicesImpl bookingServices = new BookingServicesImpl();
    static Set<Booking> bookingSet = bookingServices.bookingData();

    @Override
    public void displayCustomersGetVoucher() {
        /*2.	Display list customers get voucher*/
        for (Booking booking : bookingSet) {
            bookingStack.push(booking);
        }
        String voucher50 = "Voucher 50%";
        String voucher20 = "Voucher 20%";
        String voucher10 = "Voucher 10%";

        System.out.println("Enter number of voucher 10% ");
        int numberOfVoucher10 = 0;
        try {
            numberOfVoucher10 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter number of voucher 20% ");
        int numberOfVoucher20 = 0;
        try {
            numberOfVoucher20 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter number of voucher 50% ");
        int numberOfVoucher50 = 0;
        try {
            numberOfVoucher50 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Wrong format. Please enter again: ");
        }

        for (int i = 0; i < numberOfVoucher50; i++) {
            voucherStack.push(voucher50);
        }
        for (int i = 0; i < numberOfVoucher20; i++) {
            voucherStack.push(voucher20);
        }
        for (int i = 0; i < numberOfVoucher10; i++) {
            voucherStack.push(voucher10);
        }

        while (!bookingStack.empty()) {
            while (!voucherStack.empty()) {
                System.out.println(bookingStack.pop() + " gets a " + voucherStack.pop());
            }
        }

    }

    @Override
    public void display() {
        /*1.	Display list customers use service*/
        int year = 0;
        System.out.println("enter a year: ");
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Wrong format. Please enter again: ");
        }
        for (Booking booking: bookingSet){
            if (getYear(booking.getStartDate()) == year){
                System.out.println(displayCustomerInfo(booking.getCustomerCode()).toString());
            }
        }
    }

    public Customer displayCustomerInfo(String code) {
        for (Customer customer : customerList) {
            if (code.equals(customer.getCustomerCode())) {
                return customer;
            }
        }
        return null;
    }

    public Integer getYear(String date) {
        int year = 0;
        String[] dateArr = date.split("/");
        year = Integer.parseInt(dateArr[2]);
        return year;
    }

    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }
}
