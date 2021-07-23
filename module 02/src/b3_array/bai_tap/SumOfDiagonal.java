package b3_array.bai_tap;

import java.util.Scanner;

public class SumOfDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.println("enter the size of the matrix: ");
        size = scanner.nextInt();
        double[][] arr = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("enter the value at position " + "[" + i + "]" + "[" + j + "]");
                arr[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Display the array ["+i+"] ["+j+"] : " + arr[i][j]);
            }
        }

        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < size; i++) {
               sum1 += arr[i][i];
        }
        System.out.println("the sum of the first diagonal is: " + sum1);

        for (int i = 0; i < size; i++) {
                sum2 += arr[i][size -i -1];
        }
        System.out.println("the sum of the second diagonal is: " + sum2);
    }
}
