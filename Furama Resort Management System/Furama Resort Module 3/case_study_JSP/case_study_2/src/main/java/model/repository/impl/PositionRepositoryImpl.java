package model.repository.impl;

import model.bean.Position;
import model.repository.PositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_POSITION = "SELECT * FROM position;";
    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                positionList.add(position);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
