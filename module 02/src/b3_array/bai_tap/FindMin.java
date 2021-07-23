package b3_array.bai_tap;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int size = scanner.nextInt();
        int [] array = new int[size];
        for (int i =0; i < size; i++){
            System.out.println("enter the value at position " + i);
            array[i] = scanner.nextInt();
        }
        System.out.println("the minimum value in this array is " + findMin(array));
    }
    public static int findMin (int [] arr){
        int min = arr[0];
        for (int i= 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
