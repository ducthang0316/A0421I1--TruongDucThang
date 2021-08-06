package b6_ke_thua.bai_tap.lop_point_va_movable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        point.getXY();
        System.out.println(point.toString());

        MovablePoint movablePoint = new MovablePoint(3, 4, 5, 6);
        movablePoint.getSpeed();
        System.out.println(movablePoint.toString());
        movablePoint.move();
        System.out.println("X,Y after move: ");
        System.out.println(movablePoint.toString());
    }
}
