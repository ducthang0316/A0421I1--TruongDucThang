package b2_loop_in_java.thuc_hanh;

import javax.swing.*;
import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        if (num < 2 ){
            System.out.print(num + " is not a prime ");
        } else {
            int i =2;
            boolean check = true;
            while ( i <= Math.sqrt(num)){
                if (num % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(num + " is a prime ");
            } else {
                System.out.println(num + " is not a prime ");
            }
        }
    }
}
