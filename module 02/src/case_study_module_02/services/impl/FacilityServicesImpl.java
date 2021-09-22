package case_study_module_02.services.impl;

import case_study_module_02.models.Facility;
import case_study_module_02.models.House;
import case_study_module_02.models.Room;
import case_study_module_02.models.Villa;
import case_study_module_02.services.FacilityServices;
import case_study_module_02.utils.*;

import java.util.*;

public class FacilityServicesImpl implements FacilityServices {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public static final String REGEX_STR = "^[A-Z]\\w+$";
    public static final String VILLA_CODE_REGEX = "^SVVL-\\d{4}$";
    public static final String HOUSE_CODE_REGEX = "^SVHO-\\d{4}$";
    public static final String ROOM_CODE_REGEX = "^SVRO-\\d{4}$";
    public static final String AMOUNT_REGEX = "^[1-9]|([1][0-9])$";
    public static final String MONEY_REGEX = "^[1-9]|([1][0-9])|\\d{3,}$";
    public static final String AREA_REGEX = "^[3-9]\\d|[1-9]\\d{2,}$";

    static {
        Villa villa = new Villa("SVVL-0001", "Renting Villa", 300, 500000, 10, "Days", "High", 100, 3);
        Villa villa2 = new Villa("SVVL-0002", "Renting Villa", 300, 500000, 10, "Days", "High", 100, 3);
        House house = new House("SVHO-0001", "Renting House", 200, 300000, 6, "Months", "Medium", 2);
        Room room = new Room("SVRO-0001", "Renting Room", 100, 100000, 3, "Days", "Breakfast");
        facilityIntegerMap.put(villa, 0);
        facilityIntegerMap.put(villa2, 0);
        facilityIntegerMap.put(house, 0);
        facilityIntegerMap.put(room, 6);
        ReadAndWriteFile.writeMapFile(facilityIntegerMap, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
    }

    @Override
    public void displayListMaintenance() {
        /*3	Display list facility maintenance*/
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriteFile.readMapFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getValue() > 5) {
                System.out.println("Service name: " + entry.getKey() + ". Using times: " + entry.getValue() + " need to be maintained");
            }
        }

    }

    @Override
    public void addVilla() {

        String code = inputVillaCode();

        String nameService = inputName();

        System.out.println("Using area: ");
        double usingArea = Double.parseDouble(inputArea());

        System.out.println("Renting cost ");
        int rentCost = Integer.parseInt(inputMoney());

        System.out.println("Maximum people");
        int maxPeople = Integer.parseInt(inputAmount());

        System.out.println("Renting type ");
        String rentType = inputName();

        System.out.println("Standard ");
        String standard = inputName();

        double poolArea = Double.parseDouble(inputArea());

        System.out.println("Floor number ");
        int floor = Integer.parseInt(inputAmount());

        Villa villa = new Villa(code, nameService, usingArea, rentCost, maxPeople, rentType, standard, poolArea, floor);
        facilityIntegerMap.put(villa, 0);
        ReadAndWriteFile.writeMapFile( facilityIntegerMap, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
        System.out.println("Successfully added new Villa");
    }

    @Override
    public void addHouse() {
        String code = inputHouseCode();

        String nameService = inputName();

        System.out.println("Using area: ");
        double usingArea = Double.parseDouble(inputArea());

        System.out.println("Renting cost ");
        int rentCost = Integer.parseInt(inputMoney());

        System.out.println("Maximum people");
        int maxPeople = Integer.parseInt(inputAmount());

        System.out.println("Renting type ");
        String rentType = inputName();

        System.out.println("The standard ");
        String standard = inputName();

        System.out.println("Floor number ");
        int floor = Integer.parseInt(inputAmount());

        House house = new House(code, nameService, usingArea, rentCost, maxPeople, rentType, standard, floor);
        facilityIntegerMap.put(house, 0);
        ReadAndWriteFile.writeMapFile( facilityIntegerMap, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
        System.out.println("Successfully added new House");
    }

    @Override
    public void addRoom() {
        String code = inputRoomCode();

        String nameService = inputName();

        System.out.println("Using area: ");
        double usingArea = Double.parseDouble(inputArea());

        System.out.println("Renting cost ");
        int rentCost = Integer.parseInt(inputMoney());

        System.out.println("Maximum people");
        int maxPeople = Integer.parseInt(inputAmount());

        System.out.println("Renting type ");
        String rentType = inputName();

        System.out.println("Free services");
        String freeServices = scanner.nextLine();

        Room room = new Room(code, nameService, usingArea, rentCost, maxPeople, rentType, freeServices);
        facilityIntegerMap.put(room, 0);
        ReadAndWriteFile.writeMapFile( facilityIntegerMap, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
        System.out.println("Successfully added new Room");
    }

    @Override
    public void display() {
        /*1	Display list facility*/
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriteFile.readMapFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\facility.csv");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println("Service name: " + entry.getKey() + ". Using times: " + entry.getValue());
        }
    }

    public Map<Facility, Integer> facilityData() {
        return facilityIntegerMap;
    }


    private String inputVillaCode (){
        System.out.println("Enter service code: ");
        return RegexData.regexStr(scanner.nextLine(), VILLA_CODE_REGEX, "Wrong format (SVVL-YYYY). Please enter again:");
    }

    private String inputHouseCode (){
        System.out.println("Enter service code: ");
        return RegexData.regexStr(scanner.nextLine(), HOUSE_CODE_REGEX, "Wrong format (SVHO-YYYY). Please enter again:");
    }

    private String inputRoomCode (){
        System.out.println("Enter service code: ");
        return RegexData.regexStr(scanner.nextLine(), ROOM_CODE_REGEX, "Wrong format (SVRO-YYYY). Please enter again:");
    }

    private String inputName (){
        System.out.println("Enter the name: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "Wrong format. Please uppercase the first letter:");
    }

    private String inputArea (){
        System.out.println("Enter the area: ");
        return RegexData.regexStr(scanner.nextLine(), AREA_REGEX, "Wrong format. Area must greater than 30 :");
    }

    private String inputAmount (){
        System.out.println("Enter a number: ");
        return RegexData.regexStr(scanner.nextLine(), AMOUNT_REGEX, "Wrong format. Amount must greater than 0 and less than 20 :");
    }

    private String inputMoney (){
        System.out.println("Enter an amount: ");
        return RegexData.regexStr(scanner.nextLine(), MONEY_REGEX, "Wrong format. Amount must greater than 0 :");
    }

    @Override
    public void add() {

    }
    @Override
    public void edit() {

    }
}
