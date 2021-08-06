package b6_ke_thua.bai_tap.lop_point_2d_va_lop_point_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arrayOfXYZ = new float[3];
        arrayOfXYZ[0] = super.getX();
        arrayOfXYZ[1] = super.getY();
        arrayOfXYZ[2] = getZ();
        return arrayOfXYZ;
    }

    public String toString() {
        return "The 3D has the x= "
                + getX()
                + " and has y= "
                + getY()
                + " and has z= "
                + getZ()
                + ". The array of XYZ is " + Arrays.toString(getXYZ());
    }
}
