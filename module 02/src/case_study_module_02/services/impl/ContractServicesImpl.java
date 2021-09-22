package case_study_module_02.services.impl;

import case_study_module_02.models.Booking;
import case_study_module_02.models.Contract;
import case_study_module_02.services.ContractServices;
import case_study_module_02.utils.ReadAndWriteFile;
import case_study_module_02.utils.RegexData;

import java.util.*;

public class ContractServicesImpl implements ContractServices {

    static List<Contract> contractList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static final String MONEY_REGEX = "^[1-9]|([1][0-9])|\\d{3,}$";
    @Override
    public void display() {
        /*4.	Display list contracts*/
        contractList = (List<Contract>) ReadAndWriteFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\contract.csv");
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void add() {
        /*3.	Create new contracts*/

        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServicesImpl().bookingData();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }

        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();

            System.out.println("Making contract for Booking in which information are: " + booking.toString());

            System.out.println("Enter contract number ");
            int contractNumber = 0;
            try {
                contractNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }

            String bookingCode = booking.getBookingCode();

            System.out.println("Enter contract's deposit ");
            int deposit = Integer.parseInt(inputMoney());

            System.out.println("Enter contract's total money ");
            int totalMoney = Integer.parseInt(inputMoney());

            String customerCode = booking.getCustomerCode();

            Contract contract = new Contract(contractNumber, bookingCode, deposit, totalMoney, customerCode);
            contractList.add(contract);
            ReadAndWriteFile.write(contractList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\contract.csv");
            System.out.println("create contract successfully " + contract.toString());
        }
    }

    @Override
    public void edit() {
        /*5.	Edit contracts*/
        int contractNum;
        do {
            System.out.println("Enter contract number to edit ");
            contractNum = 0;
            try {
                contractNum = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Wrong format. Please enter again: ");
            }
        } while (!checkID(contractNum));

        System.out.println("Edit booking code");
        BookingServicesImpl bookingServices = new BookingServicesImpl();
        bookingServices.display();
        String bookingCode = scanner.nextLine();

        System.out.println("Edit contract's deposit ");
        int deposit = Integer.parseInt(inputMoney());

        System.out.println("Edit contract's total money ");
        int totalMoney = Integer.parseInt(inputMoney());

        System.out.println("Edit customer code");
        CustomerServicesImpl customerServices = new CustomerServicesImpl();
        customerServices.display();
        String customerCode = scanner.nextLine();

        int indexEdit = 0;
        for (Contract contract : contractList) {
            if (contractNum == (contract.getContractNumber())) {
                indexEdit = contractList.indexOf(contract);
            }
        }

        Contract newContract = new Contract(contractNum, bookingCode, deposit, totalMoney, customerCode);
        for (Contract contract : contractList) {
            if (contractNum == (contract.getContractNumber())) {
                contractList.set(indexEdit, newContract);
                ReadAndWriteFile.write(contractList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\contract.csv");
            }
        }
        System.out.println("Edit success");
    }

    public boolean checkID(int id) {
        for (Contract contract : contractList) {
            if (id == (contract.getContractNumber())) {
                return true;
            }
        }
        return false;
    }

    private String inputMoney (){
        System.out.println("Enter an amount: ");
        return RegexData.regexStr(scanner.nextLine(), MONEY_REGEX, "Wrong format. Amount must greater than 0 :");
    }
}
