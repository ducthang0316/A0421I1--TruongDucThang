package b6_ke_thua.bai_tap.lop_point_va_movable_point;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = new float[2];
        speed[0] = getXSpeed();
        speed[1] = getYSpeed();
        return speed;
    }

    public MovablePoint move() {
        super.setX(super.getX() + getXSpeed());
        super.setY(super.getY() + getYSpeed());
        return this;
    }

    public String toString() {
        return "The x= "
                + getX()
                + " and the y= "
                + getY()
                + ". The array of XY is " + Arrays.toString(getXY())
                + ". The array of speed is " + Arrays.toString(getSpeed());
    }


}
