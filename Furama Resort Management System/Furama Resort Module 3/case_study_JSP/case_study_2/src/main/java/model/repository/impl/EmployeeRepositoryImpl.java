package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee;";
    private final String INSERT_INTO_EMPLOYEE = "INSERT INTO employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
    private final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE employee_id = ?;";
    private final String UPDATE_EMPLOYEE = "UPDATE employee SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? WHERE employee_id = ?;";
    private final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?;";
    private final String SEARCH_EMPLOYEE = "SELECT * FROM employee WHERE employee_name like ? and employee_address like ?;";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
                employeeList.add(employee);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean save(Employee employee) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_birthday());
            preparedStatement.setString(4, employee.getEmployee_id_card());
            preparedStatement.setDouble(5, employee.getEmployee_salary());
            preparedStatement.setString(6, employee.getEmployee_phone());
            preparedStatement.setString(7, employee.getEmployee_email());
            preparedStatement.setString(8, employee.getEmployee_address());
            preparedStatement.setInt(9, employee.getPosition_id());
            preparedStatement.setInt(10, employee.getEducation_degree_id());
            preparedStatement.setInt(11, employee.getDivision_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee, int employee_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setInt(11, employee.getEmployee_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int employee_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, employee_id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Employee> search(String employee_name, String employee_address) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE);
            preparedStatement.setString(1, "%" + employee_name + "%");
            preparedStatement.setString(2, "%" + employee_address + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int employee_id = resultSet.getInt("employee_id");
                String _employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String _employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                Employee employee = new Employee(employee_id, _employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, _employee_address, position_id, education_degree_id, division_id);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
