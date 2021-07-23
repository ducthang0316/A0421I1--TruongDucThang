package b4_class_and_object_in_java.bai_tap.quadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter parameter a: ");
        double a = scanner.nextDouble();
        System.out.println("enter parameter b: ");
        double b = scanner.nextDouble();
        System.out.println("enter parameter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        System.out.println("delta of this equation is: " + delta);
        if (delta > 0){
            System.out.println("the first root is: " + quadraticEquation.getRoot1());
            System.out.println("the second root is: " + quadraticEquation.getRoot2());
        } else if (delta == 0 ){
            System.out.println("the equation has only one root is: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
