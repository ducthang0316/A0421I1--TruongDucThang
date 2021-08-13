package b7_abstractclass_interface.bai_tap.trien_khai_interface_colorable;
import b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable.Circle;
import b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable.Rectangle;
import b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable.Shape;
import b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(2, 4);
        shapes[2] = new Square(6, "blue" , true);


        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println("Area of square is: " + square.getArea());
                square.howToColor();
            }
        }
    }
}
