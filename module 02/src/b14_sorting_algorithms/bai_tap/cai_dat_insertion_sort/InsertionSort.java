package b14_sorting_algorithms.bai_tap.cai_dat_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    static int [] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void insertionSort(int[] list){
        for (int i= 1; i < list.length; i++){
            int currentElement = list[i];
            int k;
            for (k = i -1; k >=0 && list[k] > currentElement; k--){
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));;
    }
}
