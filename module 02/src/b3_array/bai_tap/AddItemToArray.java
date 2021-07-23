package b3_array.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AddItemToArray {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int [] arr = new int[10];
        for (int i =0 ; i < 6; i++){
            System.out.println("enter the element in array: ");
            arr[i] = scanner.nextInt();
        }
        int addItem, index;
        System.out.println("enter the element you want to add: ");
        addItem = scanner.nextInt();
        System.out.println("enter the position for the new element: ");
        index = scanner.nextInt();
        if (index <=1 || index>= arr.length -1){
            System.out.println("please choose another position");
        } else {
            for (int i= arr.length -1 ; i > index ; i--){
                arr[i] = arr[i -1];
            }
            arr[index] = addItem;
            System.out.println("the new array is " + Arrays.toString(arr));
        }
    }
}
