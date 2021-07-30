package b4_class_and_object_in_java.bai_tap.classFan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(3);
        fan1.setOn(true);
        fan1.setColor("yellow");
        fan1.setRadius(10);

        fan2.setSpeed(2);
        fan2.setOn(false);
        fan2.setColor("blue ");
        fan2.setRadius(5);

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());

    }
}
