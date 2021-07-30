package b5_access_modifier_static_method_static_property.bai_tap.xay_dung_lop_chi_ghi;

public class Student {
    private String name = "john";
    private String classes = "C02";

    Student(){
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setClasses(String classes) {
//        this.classes = classes;
//    }

//    private void setName(String name) {
//        this.name = name;
//    }
//
//    private void setClasses(String classes) {
//        this.classes = classes;
//    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    public void showInfo (){
        System.out.println("Name: " + this.name);
        System.out.println("Classes: " + this.classes);
    }
}
