package b6_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;


public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    private double height;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3, double height, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return (getHeight() * getSide3()) / 2;
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public String toString() {
        return "the Triangle has side1 = "
                + getSide1() + ", side2= " + getSide2() + ", side3= " + getSide3() + ", height= " + getHeight() + ", and is filled with " + getColor()
                + ". The triangle also has the area = " + getArea() + " and the perimeter = " + getPerimeter();
    }
}
