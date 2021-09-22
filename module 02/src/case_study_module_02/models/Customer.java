package case_study_module_02.models;

import java.io.Serializable;
import java.util.Date;

public class Customer extends Person implements Serializable {
    private static final int DIAMOND = 1;
    private static final int PLATINUM = 2;
    private static final int GOLD = 3;
    private static final int SILVER = 4;
    private static final int MEMBER = 5;
    private String customerCode;
    private String customerType;
    private String address;

    public Customer(){}

    public Customer(String customerCode, String customerType, String address) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String name,
                    String dateOfBirth,
                    String sex,
                    int idNumber,
                    String phoneNumber,
                    String email,
                    String customerCode,
                    String customerType,
                    String address) {
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
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
                "name='" + this.getName() + '\'' +
                "dateOfBirth='" + this.getDateOfBirth() + '\'' +
                "sex='" + this.getSex() + '\'' +
                "IdNumber='" + this.getIdNumber() + '\'' +
                "PhoneNumber='" + this.getPhoneNumber() + '\'' +
                "Email='" + this.getEmail() + '\'' +
                "customerCode='" + customerCode + '\'' +
                ", customerType=" + customerType +
                ", address='" + address + '\'' +
                '}';
    }
}
