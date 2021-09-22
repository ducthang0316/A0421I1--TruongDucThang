package case_study_module_02.services.impl;

import case_study_module_02.models.*;
import case_study_module_02.services.BookingServices;
import case_study_module_02.utils.BookingComparator;
import case_study_module_02.utils.ReadAndWriteFile;
import case_study_module_02.utils.RegexData;

import java.util.*;

public class BookingServicesImpl implements BookingServices {
    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static FacilityServicesImpl facilityServices = new FacilityServicesImpl();
    static Map<Facility, Integer> facilityIntegerMap = facilityServices.facilityData();

    static CustomerServicesImpl customerServices = new CustomerServicesImpl();
    static List<Customer> customerList = customerServices.customerData();

    /* Data to test function Display list customers get voucher */
    static {
        bookingSet.add(new Booking("bk01", "12/10/2021", "15/10/2021", "KH01", "Renting Villa", "normal"));
        bookingSet.add(new Booking("bk02", "12/10/2021", "20/10/2021", "KH02", "Renting House", "normal"));
        bookingSet.add(new Booking("bk03", "21/10/2021", "30/10/2021", "KH03", "Renting Villa", "normal"));
        bookingSet.add(new Booking("bk04", "09/10/2021", "15/10/2021", "KH04", "Renting Room", "normal"));
        ReadAndWriteFile.write(bookingSet,"E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\booking.csv");
    }


    @Override
    public void display() {
        /*2.	Display list booking.csv*/
        bookingSet = (Set<Booking>) ReadAndWriteFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\booking.csv");
        for (Booking booking : bookingSet){
            System.out.println(booking.toString());
        }
    }

    @Override
    public void add() {
        /*1.	Add new booking*/

        System.out.println("enter booking code: ");
        String code = scanner.nextLine();

        String customer = chooseCustomer();
        String facility = chooseFacility();

        System.out.println("enter the day check-in");
        String startDate = inputDate();

        System.out.println("enter the day check-out");
        String endDate = inputDate();

        System.out.println("enter the service type");
        String serviceType = scanner.nextLine();

        Booking booking = new Booking(code, startDate, endDate, customer, facility, serviceType);
        bookingSet.add(booking);
        ReadAndWriteFile.write(bookingSet,"E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\booking.csv");
        System.out.println("successfully set new booking");
    }

    public static String chooseCustomer(){
        System.out.println("Customer list include: ");
         for (Customer customer: customerList){
             System.out.println(customer.toString());
         }

        System.out.println("Enter customer code: ");
         boolean check = true;
         String customerCode = scanner.nextLine();
         while (check){
             for (Customer customer: customerList){
                 if (customerCode.equals(customer.getCustomerCode())){
                     check = false;
                     return customer.getCustomerCode();
                 }
             }
             if (check){
                 System.out.println("Wrong customer code. please re-enter customer code: ");
                 customerCode = scanner.nextLine();
             }
         }
         return null;
    }

    public static String chooseFacility(){
        System.out.println("Facility list include: ");
        for (Map.Entry<Facility,Integer> entry : facilityIntegerMap.entrySet()){
            System.out.println(entry.getKey().toString());
        }

        System.out.println("Enter facility code: ");
        boolean check = true;
        String facilityCode = scanner.nextLine();
        while (check){
            for (Map.Entry<Facility,Integer> entry : facilityIntegerMap.entrySet()){
                if (facilityCode.equals(entry.getKey().getServiceCode())){
                    check = false;
                    entry.setValue(entry.getValue() + 1);
                    return entry.getKey().getServiceName();
                }
            }
            if (check){
                System.out.println("Wrong facility code. please re-enter facility code: ");
                facilityCode = scanner.nextLine();
            }
        }
        return null;
    }

    private String inputDate (){
        System.out.println("Enter a date");
        return RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
    }

    public Set<Booking> bookingData(){
         return bookingSet;
    }


    @Override
    public void edit() {
    }

}
