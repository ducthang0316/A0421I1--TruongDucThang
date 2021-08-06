package b6_ke_thua.bai_tap.lop_point_va_movable_point;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.y = y;
        this.x = x;
    }

    public float[] getXY() {
        float[] arrayOfXY = new float[2];
        arrayOfXY[0] = x;
        arrayOfXY[1] = y;
        return arrayOfXY;
    }

    public String toString() {
        return "The x= "
                + getX()
                + " and the y= "
                + getY()
                + ". The array of XY is " + Arrays.toString(getXY());
    }
}
