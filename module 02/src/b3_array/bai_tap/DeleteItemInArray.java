package b3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteItemInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int [] arr = new int[10];
       for (int i =0 ; i < 6; i++){
           System.out.println("enter the element in array: ");
           arr[i] = scanner.nextInt();
       }

        int deleteItem;
        System.out.println("enter the item to delete: ");
        deleteItem = scanner.nextInt();

        boolean check = false;
        int indexDelete = 0;
        for (int i=0; i < arr.length; i++){
            if (deleteItem == arr[i]){
                check = true;
                indexDelete = i;
            }
        }

        if (!check){
            System.out.println("the item you enter does not exist in array");
        } else {
            for (int i= indexDelete; i<arr.length -1 ; i++){
                arr[i] = arr[i+1];
            }
            System.out.println("Array after deleted item: " +Arrays.toString(arr));
        }
    }
}
