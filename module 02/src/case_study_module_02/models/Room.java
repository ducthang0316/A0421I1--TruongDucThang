package case_study_module_02.models;

public class Room extends Facility {
    private String freeServices;

    public Room(){}

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String serviceName, double usingArea, double rentCost, int maxNumberOfPeople, String rentingTypes, String freeServices) {
        super(serviceName, usingArea, rentCost, maxNumberOfPeople, rentingTypes);
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
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
