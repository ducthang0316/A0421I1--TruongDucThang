package b1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        double usd, result, rate = 23000;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the amount of money(USD)");
        usd = scanner.nextDouble();
        result = usd * rate;
        System.out.println("Your money after changed: " + result + " VND");
    }
}
