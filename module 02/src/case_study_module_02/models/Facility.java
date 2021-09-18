package case_study_module_02.models;


public abstract class Facility {
    private String serviceName;
    private double usingArea;
    private double rentCost;
    private int maxNumberOfPeople;
    private String rentingTypes;

    public Facility(){}

    public Facility(String serviceName, double usingArea, double rentCost, int maxNumberOfPeople, String rentingTypes) {
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.rentCost = rentCost;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentingTypes = rentingTypes;
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

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
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
}
