package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String name;


    private String birthday;


    private String idCard;


    private int salary;


    private String phone;


    private String email;


    private String address;


    @ManyToOne(targetEntity = Position.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Position position;


    @ManyToOne(targetEntity = EducationDegree.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EducationDegree education;

    @ManyToOne(targetEntity = Division.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Division division;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contract> contract;

    @OneToOne(targetEntity = User.class)
    private User user;

    private String userName;

    public Employee() {
    }

    public Employee(String name, String birthday, String idCard, int salary, String phone, String email, String address, Position position, EducationDegree education, Division division, String userName) {

        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.education = education;
        this.division = division;
        this.userName = userName;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducation() {
        return education;
    }

    public void setEducation(EducationDegree education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
