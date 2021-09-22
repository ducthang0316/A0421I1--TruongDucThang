package case_study_module_02.models;

import java.io.Serializable;

public class House extends Facility implements Serializable {
    private String standard;
    private int floorNumber;

    public House(){}

    public House(String standard, int floorNumber) {
        this.standard = standard;
        this.floorNumber = floorNumber;
    }

    public House(String serviceCode,
                 String serviceName,
                 double usingArea,
                 int rentCost,
                 int maxNumberOfPeople,
                 String rentingTypes,
                 String standard,
                 int floorNumber) {
        super(serviceCode,serviceName, usingArea, rentCost, maxNumberOfPeople, rentingTypes);
        this.standard = standard;
        this.floorNumber = floorNumber;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceCode='" + this.getServiceCode() + '\'' +
                "serviceName='" + this.getServiceName() + '\'' +
                ", usingArea=" + this.getUsingArea() +'\'' +
                ", rentCost=" + this.getRentCost() +'\'' +
                ", maxNumberOfPeople=" + this.getMaxNumberOfPeople() +'\'' +
                ", rentingTypes='" + this.getRentingTypes() + '\'' +
                "standard='" + standard + '\'' +
                ", floorNumber=" + floorNumber +'\'' +
                '}';
    }
}
