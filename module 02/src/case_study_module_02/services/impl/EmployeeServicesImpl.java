package case_study_module_02.services.impl;

import case_study_module_02.models.Employee;
import case_study_module_02.services.EmployeeServices;
import case_study_module_02.utils.ReadAndWriteFile;
import case_study_module_02.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServicesImpl implements EmployeeServices {
    private static List<Employee> employeeList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    static {
        Employee employee1 = new Employee("Nguyen van A", "01/02/1999", "nam", 23114545, "0984123123", "aaa@gamil.com", "NV01", "Intermediate", "Staff", 10000 );
        Employee employee2 = new Employee("Nguyen van B", "03/05/1997", "nam", 23117896, "0984234234", "bbb@gamil.com", "NV02", "College", "Manager", 18000 );
        Employee employee3 = new Employee("Nguyen van C", "09/08/1993", "nam", 23113210, "0984789789", "ccc@gamil.com", "NV03", "Graduate& postgraduate", "Supervisor", 15000 );
        employeeList.add(employee1); employeeList.add(employee2); employeeList.add(employee3);
        ReadAndWriteFile.write(employeeList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\employee.csv");
    }

    @Override
    public void display() {
        /*1	Display list employees*/
        employeeList = (List<Employee>) ReadAndWriteFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\employee.csv");
        for (Employee employee: employeeList){
            System.out.println(employee.toString());
        }
    }

    @Override
    public void add() {
        /*2	Add new employee*/
        System.out.println("Enter employee's name: ");
        String name = scanner.nextLine();

        String date = inputAge();

        System.out.println("Enter employee's sex: ");
        String sex = scanner.nextLine();

        System.out.println("Enter employee's id number: ");
        int id = 0;
        try {
            id =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter employee's phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter employee's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter employee's code: ");
        String code = scanner.nextLine();

        System.out.println("Enter employee's level: ");
        String level = scanner.nextLine();

        System.out.println("Enter employee's position: ");
        String position = scanner.nextLine();

        System.out.println("Enter employee's salary: ");
        int salary = 0;
        try {
            salary =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        Employee employee = new Employee(name, date, sex, id, phoneNumber, email,code, level, position, salary);
        employeeList.add(employee);
        ReadAndWriteFile.write(employeeList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\employee.csv");
        System.out.println("Successfully added new employee ");


    }

    @Override
    public void edit() {
        /*3	Edit employee*/
        String code;
        int index = 0;
        do {
            System.out.println("enter the code of employee whom you want to edit: ");
            code = scanner.nextLine();
        } while (!checkCode(code));

        for (Employee employee: employeeList){
            if ((employee.getCode()).equals(code)){
                index = employeeList.indexOf(employee);
            }
        }

        System.out.println("Enter employee's name: ");
        String name = scanner.nextLine();

        String date = inputAge();

        System.out.println("Enter employee's sex: ");
        String sex = scanner.nextLine();

        System.out.println("Enter employee's id number: ");
        int id = 0;
        try {
            id =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        System.out.println("Enter employee's phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter employee's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter employee's level: ");
        String level = scanner.nextLine();

        System.out.println("Enter employee's position: ");
        String position = scanner.nextLine();

        System.out.println("Enter employee's salary: ");
        int salary = 0;
        try {
            salary =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            System.out.println("Wrong format. Please enter again: ");
        }

        Employee newEmployee = new Employee(name, date, sex, id, phoneNumber, email, code, level, position, salary);
        for (Employee employee : employeeList){
            if ((employee.getCode()).equals(code)){
                employeeList.set(index, newEmployee);
                ReadAndWriteFile.write(employeeList, "E:\\A0421I1- TruongDucThang\\module 02\\src\\case_study_module_02\\data\\employee.csv");
            }
        }
        System.out.println("Edit success");
    }

    private String inputAge (){
        System.out.println("Enter date of birth");
        return RegexData.regexAge(scanner.nextLine(), REGEX_DATE);
    }

    public boolean checkCode(String code){
        for (Employee employee: employeeList){
           if ((employee.getCode()).equals(code)){
               return true;
           }
        }
        return false;
    }

}
