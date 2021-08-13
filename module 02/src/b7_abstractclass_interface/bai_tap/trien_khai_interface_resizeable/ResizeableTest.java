package b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable;


public class ResizeableTest {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(2,4);
        shapes[2] = new Square(6);

        for (Shape shape : shapes){
            if (shape instanceof Rectangle){
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Area of rectangle is: " + rectangle.getArea());;
                double percent = Math.random()* 100 +1;
                System.out.println("Area will increase " + percent);
                rectangle.resize(percent);
                System.out.println("Area after increase: "+rectangle.getArea());
            }
        }
        System.out.println();
        for (Shape shape : shapes){
            if (shape instanceof Circle){
                Circle circle = (Circle) shape;
                System.out.println("Area of circle is: " + circle.getArea());;
                double percent = Math.random()* 100 +1;
                System.out.println("Area will increase " + percent);
                circle.resize(percent);
                System.out.println("Area after increase: "+circle.getArea());
            }
        }
        System.out.println();
        for (Shape shape : shapes){
            if (shape instanceof Square){
                Square square = (Square) shape;
                System.out.println("Area of square is: " + square.getArea());;
                double percent = Math.random()* 100 +1;
                System.out.println("Area will increase " + percent);
                square.resize(percent);
                System.out.println("Area after increase: "+square.getArea());
            }
        }
    }
}
