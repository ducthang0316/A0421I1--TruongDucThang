package b2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        double money, interestRate;
        int month;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the investment amount: ");
        money = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        month = scanner.nextInt();
        System.out.println("Enter interest rate (%): ");
        interestRate = scanner.nextDouble();
        double total = 0;
        for (int i = 0; i < month; i++){
            total += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + total);
    }
}
