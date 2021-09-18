package case_study_module_02.models;

import java.util.Date;

public class Customer extends Person {
    private static final int DIAMOND = 1;
    private static final int PLATINUM = 2;
    private static final int GOLD = 3;
    private static final int SILVER = 4;
    private static final int MEMBER = 5;
    private String customerCode;
    private int customerType;
    private String address;

    public Customer(){}

    public Customer(String customerCode, int customerType, String address) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String name, String dateOfBirth, String sex, int idNumber, String phoneNumber, String email, String customerCode, int customerType, String address) {
        super(name, dateOfBirth, sex, idNumber, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", customerType=" + customerType +
                ", address='" + address + '\'' +
                '}';
    }
}
