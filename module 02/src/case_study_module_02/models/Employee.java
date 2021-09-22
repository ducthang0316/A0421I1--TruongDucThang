package case_study_module_02.models;


import java.io.Serializable;
import java.util.Date;

public class Employee extends Person implements Serializable {
     static {
        final int INTERMEDIATE = 1;
        final int COLLEGE = 2;
        final int GRADUATE_POSTGRADUATE= 3;

        final int RECEPTIONIST = 4;
        final  int STAFF = 5;
        final  int SPECIALIST = 6;
        final int SUPERVISOR = 7;
        final int MANAGER = 8;
        final int DIRECTOR = 9;
    }
    private String code;
    private String levelOfAbility;
    private String position;
    private int salary;

    public Employee(){}

    public Employee(String code, String levelOfAbility, String position, int salary) {
        this.code = code;
        this.levelOfAbility = levelOfAbility;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name,
                    String dateOfBirth,
                    String sex,
                    int idNumber,
                    String phoneNumber,
                    String email,
                    String code,
                    String levelOfAbility,
                    String position,
                    int salary) {
        super(name, dateOfBirth, sex, idNumber, phoneNumber, email);
        this.code = code;
        this.levelOfAbility = levelOfAbility;
        this.position = position;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevelOfAbility() {
        return levelOfAbility;
    }

    public void setLevelOfAbility(String levelOfAbility) {
        this.levelOfAbility = levelOfAbility;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name= " + this.getName() + '\'' +
                "dateOfBirth= " + this.getDateOfBirth() + '\'' +
                "sex= " + this.getSex() + '\'' +
                "IdNumber= " + this.getIdNumber() + '\'' +
                "phoneNumber= " + this.getPhoneNumber() + '\'' +
                "email= " + this.getEmail() + '\'' +
                "code='" + code + '\'' +
                ", levelOfAbility='" + levelOfAbility + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
