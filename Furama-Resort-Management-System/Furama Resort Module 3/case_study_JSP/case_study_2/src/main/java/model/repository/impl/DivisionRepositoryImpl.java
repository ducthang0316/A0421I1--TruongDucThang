package model.repository.impl;

import model.bean.Division;
import model.bean.Position;
import model.repository.DivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements DivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_DIVISION = "SELECT * FROM division;";
    @Override
    public List<Division> findAll() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                divisionList.add(division);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }
}
