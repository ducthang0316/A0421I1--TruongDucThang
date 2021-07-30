package b4_class_and_object_in_java.bai_tap.classFan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public String toString(){
        if (this.isOn() == true){
            return "fan is on. " + "Speed is " + this.getSpeed() + ". Color is " + this.getColor() + ". Radius is " + this.getRadius();
        } else {
            return "fan is off. " + "Color is " + this.getColor() + ". Radius is " + this.getRadius();
        }
    }
}
