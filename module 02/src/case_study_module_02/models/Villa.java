package case_study_module_02.models;

import java.io.Serializable;

public class Villa extends Facility implements Serializable {
    private String standard;
    private double poolArea;
    private int floorNumber;

    public Villa(){}

    public Villa(String standard, double poolArea, int floorNumber) {
        this.standard = standard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa(String serviceCode,
                 String serviceName,
                 double usingArea,
                 int rentCost,
                 int maxNumberOfPeople,
                 String rentingTypes,
                 String standard,
                 double poolArea,
                 int floorNumber) {
        super(serviceCode, serviceName, usingArea, rentCost, maxNumberOfPeople, rentingTypes);
        this.standard = standard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceCode='" + this.getServiceCode() + '\'' +
                "serviceName='" + this.getServiceName() + '\'' +
                ", usingArea=" + this.getUsingArea() +'\'' +
                ", rentCost=" + this.getRentCost() +'\'' +
                ", maxNumberOfPeople=" + this.getMaxNumberOfPeople() +'\'' +
                ", rentingTypes='" + this.getRentingTypes() + '\'' +
                "standard='" + standard + '\'' +
                ", poolArea=" + poolArea +'\'' +
                ", floorNumber=" + floorNumber +'\'' +
                '}';
    }
}
