package b10_DSA_danh_sach.bai_tap.trien_khai_ArrayList;

public class MyArrayListTest {
    public static class Student {
        private int id;
        private String name;

        public Student(){}
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            return "Name: " + this.getName() + ". Id: " + this.getId();
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nam");
        Student student2 = new Student(2, "Hai");
        Student student3 = new Student(3, "Trieu");
        Student student4 = new Student(4, "Thinh");
        Student student5 = new Student(5, "Hoa");
        Student student6 = new Student(6, "Hoa2");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(student5);

        studentMyArrayList.add(3,student6);

        for (int i=0 ; i < studentMyArrayList.getSize(); i++ ){
            studentMyArrayList.printInfo(studentMyArrayList.get(i));
        }

//        System.out.println((studentMyArrayList.get(2)).toString());
//
//        Student student7 = new Student(7, "Hung");
//        System.out.println(studentMyArrayList.add(student7));
//
//        System.out.println(studentMyArrayList.indexOf(student3));
//
//        Student student8 = new Student(8, "Hoang");
//        System.out.println(studentMyArrayList.contains(student8));
//
//        MyArrayList<Student> cloneMyArrayList = new MyArrayList<>();
//        cloneMyArrayList = studentMyArrayList.clone();
//        System.out.println("Cloned list: ");
//        for (int i=0 ; i < cloneMyArrayList.getSize(); i++ ){
//            cloneMyArrayList.printInfo(studentMyArrayList.get(i));
//        }

        System.out.println("Removed item: " + studentMyArrayList.remove(1));

        studentMyArrayList.clear();
    }
}
