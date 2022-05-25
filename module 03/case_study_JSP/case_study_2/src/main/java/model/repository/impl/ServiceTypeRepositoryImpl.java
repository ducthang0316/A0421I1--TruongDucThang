package model.repository.impl;

import model.bean.Position;
import model.bean.ServiceType;
import model.repository.ServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_SERVICE_TYPE = "SELECT * FROM service_type;";
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(service_type_id, service_type_name);
                serviceTypeList.add(serviceType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
