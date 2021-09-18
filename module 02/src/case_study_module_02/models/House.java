package case_study_module_02.models;

public class House extends Facility{
    private String standard;
    private int floorNumber;

    public House(){}

    public House(String standard, int floorNumber) {
        this.standard = standard;
        this.floorNumber = floorNumber;
    }

    public House(String serviceName, double usingArea, double rentCost, int maxNumberOfPeople, String rentingTypes, String standard, int floorNumber) {
        super(serviceName, usingArea, rentCost, maxNumberOfPeople, rentingTypes);
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
                "standard='" + standard + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
