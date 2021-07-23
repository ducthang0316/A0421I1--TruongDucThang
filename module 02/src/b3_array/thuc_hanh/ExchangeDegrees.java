package b3_array.thuc_hanh;

import java.util.Scanner;

public class ExchangeDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit, celsius;
        int choice;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:{
                    System.out.println("enter Fahrenheit:");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                }
                case 2:{
                    System.out.println("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                }
                case 0:
                    System.exit(0);
            }

        } while (choice !=0);
    }

    public static double celsiusToFahrenheit (double c){
        double fahrenheit = (9.0 / 5) * c + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius (double f){
        double celsius = (5.0 / 9) * (f - 32);
        return celsius;
    }
}
