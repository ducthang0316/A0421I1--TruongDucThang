package b3_array.thuc_hanh;

import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        int size;
        int [] arr;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter the size of the array: ");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("the size must not exceed 20");
            }
        }while (size>20);
        arr = new int[size];
        int i =0;
        while ( i < size){
            System.out.println("enter the element at " + (i+1));
            arr[i]= scanner.nextInt();
            i++;
        }
        System.out.println("property list: ");
        for (int j =0; j < arr.length; j++){
            System.out.println(arr[j] + "\t");
        }
        int max = arr[0];
        int index = 1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
                index = j + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
