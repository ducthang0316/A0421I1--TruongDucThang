package b2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0){
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for (int i = 5; i >= 1; i--){
                        for (int j = 1; j <= i; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++){
                        for (int j = 1; j <= 5; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 3; i++){
                        for (int j = 1; j <= 6; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice ");
            }
        }
    }
}
