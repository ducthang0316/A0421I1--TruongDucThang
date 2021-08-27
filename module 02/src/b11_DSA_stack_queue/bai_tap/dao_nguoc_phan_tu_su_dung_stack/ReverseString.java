package b11_DSA_stack_queue.bai_tap.dao_nguoc_phan_tu_su_dung_stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string: ");
        String str = scanner.nextLine();
        char [] charArr = str.toCharArray();

        Stack<Character> myStack = new Stack<>();
        for (int i=0; i< charArr.length; i++){
            myStack.push(charArr[i]);
        }

        for (int i=0; i< charArr.length; i++){
            charArr[i] = myStack.pop();
        }

        String newStr = "";
        System.out.println("String after reversed is: ");
        for (int i=0; i< charArr.length; i++){
            newStr+= charArr[i];
        }
        System.out.println(newStr);
    }
}
