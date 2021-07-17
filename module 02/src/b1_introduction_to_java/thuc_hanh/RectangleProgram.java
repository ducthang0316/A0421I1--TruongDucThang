package b1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class RectangleProgram {
    public static void main(String[] args) {
        float width, height;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the width: ");
        width = scanner.nextFloat();

        System.out.println("Enter the height: ");
        height = scanner.nextFloat();

        float area = width * height;
        System.out.println("Area is " + area);
    }
}
