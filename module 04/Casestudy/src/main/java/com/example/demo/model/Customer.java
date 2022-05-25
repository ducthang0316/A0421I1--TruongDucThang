package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( targetEntity = CustomerType.class )
    private CustomerType customerType;

    @NotBlank(message = "Name must not blank")
    private String name;

    @NotBlank(message = "Birthday must not blank")
    private String birthday;


    private int gender;

    @NotBlank(message = "Id card must not blank")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "Id card is in wrong format")
    private String idCard;

    @NotBlank(message = "Phone must not blank")
    @Pattern(regexp = "^(090\\d{7}|091\\d{7}|\\(84\\)\\+90\\d{7}|\\(84\\)\\+91\\d{7})$", message = "Phone number must follow format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String phone;

    @NotBlank(message = "Email must not blank")
    @Email
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email is in wrong format")
    private String email;

    @NotBlank(message = "Address must not blank")
    private String address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer() {
    }

    public Customer( CustomerType customerType, String name, String birthday, int gender, String idCard, String phone, String email, String address) {

        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
}
