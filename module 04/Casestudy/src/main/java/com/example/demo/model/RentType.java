package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rentTypeName;

    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private List<Service> service;

    public RentType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }
}
