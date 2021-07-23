package b3_array.bai_tap;

import java.util.Scanner;

public class FindMaxInTwoDimensionalArrays {
    public static void main(String[] args) {
        findMax();
    }

    public static void findMax() {
        double max;
        int x=0, y=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of rows in matrix: ");
        int rows = scanner.nextInt();
        System.out.println("enter the number of columns in matrix: ");
        int columns = scanner.nextInt();
        double[][] arr = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("enter the value at position " + "[" + i + "]" + "[" + j + "]");
                arr[i][j] = scanner.nextDouble();
            }
        }
        max = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (max < arr[i][j]){
                    max = arr[i][j];
                    y = j;
                    x = i;
                }
            }
        }
        System.out.println("the maximum value in this array is " + max + " at position " + "[" + x + "]" + "[" + y + "]");
    }
}
