package b1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Enter a year: ");
        year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0){
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is not a leap year ", year);
        }
    }
}
