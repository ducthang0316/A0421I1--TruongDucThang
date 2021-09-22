package case_study_module_02.models;


import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String serviceCode;
    private String serviceName;
    private double usingArea;
    private int rentCost;
    private int maxNumberOfPeople;
    private String rentingTypes;

    public Facility(){}

    public Facility(String serviceCode, String serviceName, double usingArea, int rentCost, int maxNumberOfPeople, String rentingTypes) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.rentCost = rentCost;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentingTypes = rentingTypes;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentingTypes() {
        return rentingTypes;
    }

    public void setRentingTypes(String rentingTypes) {
        this.rentingTypes = rentingTypes;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceCode='" + serviceCode + '\'' +
                "serviceName='" + serviceName + '\'' +
                ", usingArea=" + usingArea +'\'' +
                ", rentCost=" + rentCost +'\'' +
                ", maxNumberOfPeople=" + maxNumberOfPeople +'\'' +
                ", rentingTypes='" + rentingTypes + '\'' +
                '}';
    }
}
