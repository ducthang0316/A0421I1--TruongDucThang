package b2_loop_in_java.bai_tap;

import java.util.Scanner;

public class DisplayShape {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0){
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle ");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for (int i = 1; i <= 3; i++){
                        for (int j = 1; j <= 6; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for (int i = 7; i >= 1; i--){
                        for (int j = 1; j <= i; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    int height = 6;
                    for (int i =1 ; i <= height; i++){
                        for (int j = 1; j <= height - i; j++){
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice ");
            }
        }
    }
}
