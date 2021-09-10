package b15_debug_exception.bai_tap.su_dung_IllegalTriangleException;

import java.util.Scanner;

public class TriangleCheck {
    public void checkTriangle() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        double side1 = 0;
        double side2 = 0;
        double side3 = 0;
        try {
            System.out.println("enter the first side: ");
            side1 = scanner.nextDouble();
            System.out.println("enter the second side: ");
            side2 = scanner.nextDouble();
            System.out.println("enter the third side: ");
            side3 = scanner.nextDouble();
            throw new IllegalTriangleException();
        } catch (IllegalTriangleException exception) {
            if (!isNegative(side1, side2, side3)) {
                throw new IllegalTriangleException("The side must be positive");
            } else if (!isTriangle(side1, side2, side3)) {
                throw new IllegalTriangleException("The sum of two side must greater than the remain side");
            }
            System.out.println("side1 = " + side1 + " & side2 = " + side2 + " & side3 = " + side3 + " are the three sides of a triangle");
        }
    }

    public boolean isNegative(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isTriangle(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            return true;
        }
        return false;
    }
}
