package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String customerTypeName;

    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customer;


    public CustomerType() {
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public CustomerType( String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
