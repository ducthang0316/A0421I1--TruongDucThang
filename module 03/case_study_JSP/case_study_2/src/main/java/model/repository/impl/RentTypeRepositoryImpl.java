package model.repository.impl;

import model.bean.Position;
import model.bean.RentType;
import model.repository.RentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_RENT_TYPE = "SELECT * FROM rent_type;";
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rent_type_id = resultSet.getInt("rent_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                double rent_type_cost = resultSet.getDouble("rent_type_cost");
                RentType rentType = new RentType(rent_type_id, rent_type_name, rent_type_cost);
                rentTypeList.add(rentType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }
}
