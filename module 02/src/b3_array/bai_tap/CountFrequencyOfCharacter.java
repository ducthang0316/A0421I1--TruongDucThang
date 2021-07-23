package b3_array.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CountFrequencyOfCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count =0;
        String str;
        char character;
        System.out.println("enter a string ");
        str = scanner.nextLine();
        System.out.println("enter a character you want to count ");
        character = scanner.next().charAt(0);
        countChar(str, character);
    }
    public static void countChar (String str, char character){
        int count =0;
        for (int i=0; i < str.length(); i++){
            if (str.charAt(i) == character){
                count++;
            }
        }
        System.out.println("the character "+character+" appear "+count+" times ");
    }
}
