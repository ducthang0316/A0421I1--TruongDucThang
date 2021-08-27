package b11_DSA_stack_queue.bai_tap.dao_nguoc_phan_tu_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseInterger {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("Array before reversed: " + Arrays.toString(arr));
        myStack.setSize(arr.length);

        for (int i = 0; i < arr.length; i++) {
            myStack.push(arr[i]);
        }

        int[] newArr = new int[10];
        for (int i = 0; i < myStack.size(); i++) {
            newArr[i] = myStack.pop();
        }

        arr = newArr;
        System.out.println("Array after reversed: " + Arrays.toString(arr));
    }
}


