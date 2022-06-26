package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String serviceName;


    private int area;


    private Double cost;


    private int maxPeople;


    @ManyToOne(targetEntity = RentType.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RentType rentType;


    @ManyToOne(targetEntity = ServiceType.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ServiceType serviceType;


    private String standard;


    private String description;


    private double poolArea;


    private int floor;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Service() {
    }

    public Service( String serviceName, int area, Double cost, int maxPeople, RentType rentType, ServiceType serviceType, String standard, String description, double poolArea, int floor) {

        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
