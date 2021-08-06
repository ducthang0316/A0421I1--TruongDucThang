package b6_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a color you want to fill the shape: ");
        Shape shape = new Shape(scanner.nextLine());
        System.out.println(shape.toString());

        Triangle triangle = new Triangle();
        System.out.println("enter side 1 of the triangle: ");
        triangle.setSide1(scanner.nextDouble());
        System.out.println("enter side 2 of the triangle: ");
        triangle.setSide2(scanner.nextDouble());
        System.out.println("enter side 3 of the triangle: ");
        triangle.setSide3(scanner.nextDouble());
        System.out.println("enter the height of the triangle: ");
        triangle.setHeight(scanner.nextDouble());
        System.out.println("enter the color of the triangle: ");
        triangle.setColor(scanner.nextLine());
        triangle.getArea();
        triangle.getPerimeter();
        System.out.println(triangle.toString());
    }
}
