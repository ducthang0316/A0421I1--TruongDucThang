package b2_loop_in_java.bai_tap;

import java.util.Scanner;

public class DisplayPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount, count = 1, number = 2;
        System.out.println("Enter the number of prime you want to print: ");
        amount = scanner.nextInt();
        while (count <= amount){
            boolean temp = true;
            for (int i = 2; i <= Math.sqrt(number); i++){
                if (number % i == 0){
                    temp = false;
                    break;
                }
            }
            if (temp){
                System.out.println("the prime number at " + count +  " is " + number);
                count++;
            }
            number++;
        }
    }
}
