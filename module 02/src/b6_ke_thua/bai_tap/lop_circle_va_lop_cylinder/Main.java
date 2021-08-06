package b6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "red");
        circle.getArea();
        System.out.println(circle.toString());;

        Cylinder cylinder = new Cylinder(4, "blue" , 6);
        cylinder.getVolume();
        System.out.println(cylinder.toString());;
    }
}
