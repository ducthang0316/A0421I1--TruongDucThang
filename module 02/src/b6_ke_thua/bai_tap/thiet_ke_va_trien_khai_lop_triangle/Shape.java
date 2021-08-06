package b6_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Shape {
    private String color;

    public Shape(){}

    public Shape(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "the shape is filled with " + getColor();
    }
}
