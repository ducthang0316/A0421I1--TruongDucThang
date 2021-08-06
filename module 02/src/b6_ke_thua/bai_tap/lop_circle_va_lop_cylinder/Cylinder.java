package b6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public String toString(){
        return "A Cylinder with radius = "
                + getRadius()
                + " and has the height = "
                + getHeight()
                + " and filled with "
                + getColor()
                + " and has the Volume = "
                + getVolume();
    }
}
