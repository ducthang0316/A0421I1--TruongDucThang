package case_study_module_02.models;

import java.io.Serializable;

public class Contract implements Serializable {
    private int contractNumber;
    private String bookingCode;
    private int deposit;
    private int totalMoney;
    private String customerCode;

    public Contract(){}

    public Contract(int contractNumber, String bookingCode, int deposit, int totalMoney, String customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customerCode = customerCode;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
