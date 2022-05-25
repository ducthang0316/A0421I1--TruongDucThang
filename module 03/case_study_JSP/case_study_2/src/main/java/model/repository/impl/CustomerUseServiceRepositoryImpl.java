package model.repository.impl;

import model.bean.AttachService;
import model.bean.Customer;
import model.bean.Service;
import model.repository.CustomerUseServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUseServiceRepositoryImpl implements CustomerUseServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_CUSTOMER_USE_SERVICE = "SELECT * FROM customer join contract on contract.customer_id = customer.customer_id join service on service.service_id = contract.service_id left join contract_detail on contract_detail.contract_id = contract.contract_id left join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerUseServiceList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_USE_SERVICE);
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
                String service_name = resultSet.getString("service_name");
                String attach_service_name = resultSet.getString("attach_service_name");
                if (attach_service_name == null){
                    attach_service_name = "No";
                }

                Service service = new Service(service_name);
                AttachService attachService = new AttachService(attach_service_name);

                Customer customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, service, attachService);
                customerUseServiceList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUseServiceList;
    }
}
