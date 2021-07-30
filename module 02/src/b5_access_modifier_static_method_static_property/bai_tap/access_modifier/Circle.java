package b5_access_modifier_static_method_static_property.bai_tap.access_modifier;

public class Circle {
    private double radius = 1;
    private String color = "red";

    Circle(){
    }
    Circle( double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

//    private double getRadius(){
//        return this.radius;
//    }
//    private double getArea(){
//        return Math.PI * this.radius * this.radius;
//    }
//
//    protected double getRadius(){
//        return this.radius;
//    }
//    protected double getArea(){
//        return Math.PI * this.radius * this.radius;
//    }
}
