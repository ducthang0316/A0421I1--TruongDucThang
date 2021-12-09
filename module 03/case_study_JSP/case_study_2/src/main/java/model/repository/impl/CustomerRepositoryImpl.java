package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "select * from customer;";
    private final String INSERT_CUSTOMER = "INSERT INTO customer" +
            "  (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final  String  DELETE = "DELETE FROM customer where customer_id = ? ;";
    private  final  String UPDATE = "call edit_customer_by_id (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_BY_ID = "select * from customer where customer_id = ?;";
    private final String SEARCH = "  select * from customer where customer_name like ? and customer_address like ? and customer_type_id like ? ;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                int customerType = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = String.valueOf(resultSet.getDate("customer_birthday"));
                int gender = resultSet.getByte("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Customer customer = new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        Customer customer  =null;
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("customer_id");
                int customerType = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = String.valueOf(resultSet.getDate("customer_birthday"));
                int gender = resultSet.getByte("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id1, customerType, name, birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) {
        Connection connection= null;
        boolean check = false;
        connection = baseRepository.connectDataBase();

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setInt(2, customer.getCustomerType());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setDate(4, Date.valueOf(customer.getBirthday()));
            preparedStatement.setInt(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }


    @Override
    public boolean delete(int id) {
        Connection connection = null;
        connection =baseRepository.connectDataBase();
        boolean check = false;

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(int id, Customer customer) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, customer.getCustomerType());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setDate(4, Date.valueOf(customer.getBirthday()));
            preparedStatement.setInt(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return check;
    }

    @Override
    public List<Customer> search(String name, String address, String type) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            String str1 = "%" + name +"%";
            String str2 = "%" + address +"%";
            String str3 = "%" + type +"%";
            preparedStatement.setString(1, str1);
            preparedStatement.setString(2, str2);
            preparedStatement.setString(3, str3);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                int customerType = resultSet.getInt("customer_type_id");
                String name1 = resultSet.getString("customer_name");
                String birthday = String.valueOf(resultSet.getDate("customer_birthday"));
                int gender = resultSet.getByte("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address1 = resultSet.getString("customer_address");
                Customer customer = new Customer(id, customerType, name1, birthday, gender, idCard, phone, email, address1);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
