package b5_access_modifier_static_method_static_property.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        System.out.println(circle1.getRadius());
        System.out.println(circle1.getArea());
    }
}
