package b13_searching_algorithms.bai_tap.tim_chuoi_co_do_dai_lon_nhat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void findString (String str){
        ArrayList<Character> result = new ArrayList<>();
         for (int i =0; i< str.length(); i++){
             ArrayList<Character> charList = new ArrayList<>();
             charList.add(str.charAt(i));

             for (int j = i+1; j < str.length(); j++){
                 if (str.charAt(j) > charList.get(charList.size()-1)){
                     charList.add(str.charAt(j));
                 }
             }

             if (charList.size() > result.size()){
                 result.clear();
                 result.addAll(charList);
             }
             charList.clear();
         }

        System.out.println("the result is: " + result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string: ");
        String str = scanner.nextLine();
        findString(str);
    }
}
