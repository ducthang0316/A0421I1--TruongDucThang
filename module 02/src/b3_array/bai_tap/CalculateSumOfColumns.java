package b3_array.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateSumOfColumns {
    public static void main(String[] args) {
        System.out.println("the sum of the column is: " + calculateSum());
    }
    public static int calculateSum (){
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
        System.out.println("enter the column you want to calculate: ");
        int col = scanner.nextInt();
        int sum =0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               if (j == col){
                   sum+= arr[i][j];
               }
            }
        }
        return sum;
    }
}
