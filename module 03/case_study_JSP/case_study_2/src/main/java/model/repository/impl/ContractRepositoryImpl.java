package model.repository.impl;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.ContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_CONTRACT = "SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id;";
    private final String INSERT_INTO_CONTRACT = "INSERT INTO contract(contract_id, contract_start_date, " +
            "contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) " +
            "VALUES (?,?,?,?,?,?,?,?);";
    private final String SELECT_CONTRACT_BY_ID = "SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id HAVING contract_id = ?;";
    private final String UPDATE_CONTRACT = "UPDATE contract SET contract_start_date = ?, contract_end_date = ?," +
            "contract_deposit = ?, contract_total_money = ?, employee_id = ?, customer_id = ?, service_id = ? WHERE contract_id = ?;";
    private final String DELETE_CONTRACT = "DELETE FROM contract WHERE contract_id = ?;";
    private final String SEARCH_CONTRACT = "SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id WHERE employee_name like ? and service_name like ? and customer_name like ?;";



    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");

                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                Customer customer = new Customer(customer_name);
                Employee employee = new Employee(employee_name);
                Service service = new Service(service_name);

                Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id, service, customer, employee);
                contractList.add(contract);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean save(Contract contract) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CONTRACT);
            preparedStatement.setInt(1, contract.getContract_id());
            preparedStatement.setString(2, contract.getContract_start_date());
            preparedStatement.setString(3, contract.getContract_end_date());
            preparedStatement.setDouble(4, contract.getContract_deposit());
            preparedStatement.setDouble(5, contract.getContract_total_money());
            preparedStatement.setInt(6, contract.getEmployee_id());
            preparedStatement.setInt(7, contract.getCustomer_id());
            preparedStatement.setInt(8, contract.getService_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Contract findById(int id) {
        Contract contract = null;
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");

                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                Customer customer = new Customer(customer_name);
                Employee employee = new Employee(employee_name);
                Service service = new Service(service_name);

                contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id, service, customer, employee);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public boolean update(Contract contract, int contract_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT);
            preparedStatement.setString(1, contract.getContract_start_date());
            preparedStatement.setString(2, contract.getContract_end_date());
            preparedStatement.setDouble(3, contract.getContract_deposit());
            preparedStatement.setDouble(4, contract.getContract_total_money());
            preparedStatement.setInt(5, contract.getEmployee_id());
            preparedStatement.setInt(6, contract.getCustomer_id());
            preparedStatement.setInt(7, contract.getService_id());
            preparedStatement.setInt(8, contract.getContract_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int contract_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT);
            preparedStatement.setInt(1, contract_id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Contract> search(String employee, String customer, String service) {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CONTRACT);
            preparedStatement.setString(1, "%" + employee + "%");
            preparedStatement.setString(2, "%" + service + "%");
            preparedStatement.setString(3, "%" + customer + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");

                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                Customer _customer = new Customer(customer_name);
                Employee _employee = new Employee(employee_name);
                Service _service = new Service(service_name);
                Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id, _service, _customer, _employee);
                contractList.add(contract);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contractList;
    }
}
