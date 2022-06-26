package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startDate;

    private String endDate;

    private Double deposit;

    private Double totalMoney;

    @ManyToOne(targetEntity = Employee.class )
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class )
    private Customer customer;

    @ManyToOne(targetEntity = Service.class )
    private Service service;



}
