package b3_array.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AddArrayToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr1 = new int[5];
        int [] arr2 = new int[5];
        int [] arr3 = new int[arr1.length + arr2.length];
        for (int i= 0; i < arr1.length; i++){
            System.out.println("enter the value of array 1: ");
            arr1[i] = scanner.nextInt();
        }
        for (int i= 0; i < arr2.length; i++){
            System.out.println("enter the value of array 2: ");
            arr2[i] = scanner.nextInt();
        }
        for (int i= 0; i < arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for (int i= 0; i < arr2.length; i++){
            arr3[arr2.length +i ] = arr2[i];
        }
        System.out.println("the array 1 is: " + Arrays.toString(arr1));
        System.out.println("the array 2 is: " + Arrays.toString(arr2));
        System.out.println("the array 3 is: " + Arrays.toString(arr3));
    }
}
