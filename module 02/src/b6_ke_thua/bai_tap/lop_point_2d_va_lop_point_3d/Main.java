package b6_ke_thua.bai_tap.lop_point_2d_va_lop_point_3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(5, 7);
        point2D.getXY();
        System.out.println(point2D.toString());

        Point3D point3D = new Point3D(2, 4, 6);
        point3D.getXYZ();
        System.out.println(point3D.toString());
    }
}
