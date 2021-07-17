package b2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a: ");
        a = scanner.nextInt();
        System.out.println("enter b: ");
        b = scanner.nextInt();

         a= Math.abs(a);
         b = Math.abs(b);

         if(a==0 || b==0){
             System.out.println("No greatest common factor");
         }
         while (a != b){
             if (a > b){
                 a = a-b;
             } else {
                 b = b- a;
             }
         }
        System.out.println("the greatest common factor is: " + a);
    }
}
