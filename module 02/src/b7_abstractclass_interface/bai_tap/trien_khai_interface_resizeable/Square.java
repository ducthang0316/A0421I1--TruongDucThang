package b7_abstractclass_interface.bai_tap.trien_khai_interface_resizeable;

import b7_abstractclass_interface.bai_tap.trien_khai_interface_colorable.Colorable;

public class Square extends Shape implements Resizeable, Colorable {
    private double side =1.0;
    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super( color, filled);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return this.side * this.side;
    }


    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize (double percent){
       this.side += this.side * percent /100;

    }
    @Override
    public void howToColor(){
        System.out.println("Color all four sides is " + this.getColor());
    }
}
