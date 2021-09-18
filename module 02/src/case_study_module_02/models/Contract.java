package case_study_module_02.models;

public abstract class Contract {
    private int contractNumber;
    private String bookingCode;
    private double deposit;
    private double totalMoney;
    private String customerCode;

    public Contract(){}

    public Contract(int contractNumber, String bookingCode, double deposit, double totalMoney, String customerCode) {
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

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
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
