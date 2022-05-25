package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer;";
    private final String INSERT_INTO_CUSTOMER = "INSERT INTO customer(customer_id, customer_name, customer_birthday, " +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values" +
            "(?,?,?,?,?,?,?,?,?);";
    private final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE customer_id = ?;";
    private final String UPDATE_CUSTOMER = "UPDATE customer set customer_name = ?, customer_birthday = ?, customer_gender = ?," +
            "customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? WHERE customer_id = ?;";
    private final String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?";
    private final String SEARCH_CUSTOMER = "SELECT * FROM customer WHERE customer_name like ? and customer_address like ?;";


    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean save(Customer customer) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_birthday());
            preparedStatement.setInt(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.setInt(9, customer.getCustomer_type_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean update(Customer customer, int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomer_name());
            preparedStatement.setString(2, customer.getCustomer_birthday());
            preparedStatement.setInt(3, customer.getCustomer_gender());
            preparedStatement.setString(4, customer.getCustomer_id_card());
            preparedStatement.setString(5, customer.getCustomer_phone());
            preparedStatement.setString(6, customer.getCustomer_email());
            preparedStatement.setString(7, customer.getCustomer_address());
            preparedStatement.setInt(8, customer.getCustomer_type_id());
            preparedStatement.setInt(9, customer.getCustomer_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Customer> search(String customer_name, String customer_address) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + customer_name + "%");
            preparedStatement.setString(2, "%" + customer_address + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String _customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String _customer_address = resultSet.getString("customer_address");
                Customer customer = new Customer(customer_id, customer_type_id, _customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, _customer_address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
}
