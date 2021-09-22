package case_study_module_02.models;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String freeServices;

    public Room(){}

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String serviceCode,
                String serviceName,
                double usingArea,
                int rentCost,
                int maxNumberOfPeople,
                String rentingTypes,
                String freeServices) {
        super(serviceCode,serviceName, usingArea, rentCost, maxNumberOfPeople, rentingTypes);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceCode='" + this.getServiceCode() + '\'' +
                "serviceName='" + this.getServiceName() + '\'' +
                ", usingArea=" + this.getUsingArea() +'\'' +
                ", rentCost=" + this.getRentCost() +'\'' +
                ", maxNumberOfPeople=" + this.getMaxNumberOfPeople() +'\'' +
                ", rentingTypes='" + this.getRentingTypes() + '\'' +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
