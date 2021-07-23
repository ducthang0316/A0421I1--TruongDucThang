package b3_array.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20 ){
                System.out.println("the size must not exceed 20");
            }
        } while (size >20 );
        array = new int [size];
        int i =0;
        while (i <size){
            System.out.println("Enter element at " + (i+1)+ " :");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "element in array: ","");
        for (int j=0; j < array.length; j++){
            System.out.println(array[j] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
