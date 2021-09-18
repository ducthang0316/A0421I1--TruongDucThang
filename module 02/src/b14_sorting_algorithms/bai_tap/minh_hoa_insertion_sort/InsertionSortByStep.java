package b14_sorting_algorithms.bai_tap.minh_hoa_insertion_sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void insertionSortByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            System.out.println();
            System.out.println("insert " + list[i] +" into a sorted sublist" );
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                System.out.println("Because list[ k= " + k + "] = " + list[k] +" > currentElement = "+ currentElement + ". Assign list[k] = " + list[k] + " to list[k+1] = " + list[k+1]);
                list[k + 1] = list[k];
            }

            System.out.println("Insert currentElement= " + currentElement + " into position k = " + (k+1) + " in " + Arrays.toString(list));
            list[k + 1] = currentElement;

            System.out.print("List after the " + i + " times sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter list size ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSortByStep(list);
    }
}
