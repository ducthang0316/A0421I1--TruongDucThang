package model.repository.impl;

import model.bean.AttachService;
import model.bean.Position;
import model.repository.AttachServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepositoryImpl implements AttachServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_ATTACH_SERVICE = "SELECT * FROM attach_service;";

    @Override
    public List<AttachService> findAll() {
        List<AttachService> attachServiceList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attach_service_id = resultSet.getInt("attach_service_id");
                String attach_service_name = resultSet.getString("attach_service_name");
                double attach_service_cost = resultSet.getDouble("attach_service_cost");
                int attach_service_unit = resultSet.getInt("attach_service_unit");
                String attach_service_status = resultSet.getString("attach_service_status");

                AttachService attachService = new AttachService(attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, attach_service_status);
                attachServiceList.add(attachService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;
    }
}
