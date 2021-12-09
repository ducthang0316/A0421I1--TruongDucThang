package model.repository.impl;

import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;
import model.service.CustomerTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_TYPE = "select * from customer_type;";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> typeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDataBase();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("customer_type_id");
                String typeName = resultSet.getString("customer_type_name");
                typeList.add(new CustomerType(id, typeName));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeList;
    }
}
