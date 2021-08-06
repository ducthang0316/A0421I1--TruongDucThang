package b6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle (){}
    public Circle (double radius, String color){
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea (){
        return Math.PI* this.radius * this.radius;
    }
    public String toString(){
        return "A Circle with radius = "
                + getRadius()
                + " and filled with "
                + getColor()
                + " and has the Area = "
                + getArea();
    }
}
