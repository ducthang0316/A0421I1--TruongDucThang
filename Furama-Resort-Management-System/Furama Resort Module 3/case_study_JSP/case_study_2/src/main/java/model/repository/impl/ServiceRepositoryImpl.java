package model.repository.impl;

import model.bean.Service;
import model.repository.ServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_SERVICES = "SELECT * FROM service;";
    private final String INSERT_INTO_SERVICE = "INSERT INTO service(service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id) VALUES (?,?,?,?,?,?,?,?,?,?);";
    private final String SELECT_SERVICE_BY_ID = "SELECT * FROM service WHERE service_id = ?;";
    private final String UPDATE_SERVICE = "UPDATE service SET service_name = ?, service_area = ?, service_cost = ?, service_max_people = ?, standard_room = ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ?, rent_type_id = ?, service_type_id = ? WHERE service_id = ?;";
    private final String DELETE_SERVICE = "DELETE FROM service WHERE service_id = ?;";
    private final String SEARCH_SERVICE = "SELECT * FROM service WHERE service_name like ?;";

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                double service_area = resultSet.getDouble("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                Service service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
                serviceList.add(service);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean save(Service service) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);
            preparedStatement.setString(1, service.getService_name());
            preparedStatement.setDouble(2, service.getService_area());
            preparedStatement.setDouble(3, service.getService_cost());
            preparedStatement.setInt(4, service.getService_max_people());
            preparedStatement.setString(5, service.getStandard_room());
            preparedStatement.setString(6, service.getDescription_other_convenience());
            preparedStatement.setDouble(7, service.getPool_area());
            preparedStatement.setInt(8, service.getNumber_of_floors());
            preparedStatement.setInt(9, service.getRent_type_id());
            preparedStatement.setInt(10, service.getService_type_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Service findById(int id) {
        Service service = null;
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                double service_area = resultSet.getDouble("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public boolean update(Service service, int service_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
            preparedStatement.setString(1, service.getService_name());
            preparedStatement.setDouble(2, service.getService_area());
            preparedStatement.setDouble(3, service.getService_cost());
            preparedStatement.setInt(4, service.getService_max_people());
            preparedStatement.setString(5, service.getStandard_room());
            preparedStatement.setString(6, service.getDescription_other_convenience());
            preparedStatement.setDouble(7, service.getPool_area());
            preparedStatement.setInt(8, service.getNumber_of_floors());
            preparedStatement.setInt(9, service.getRent_type_id());
            preparedStatement.setInt(10, service.getService_type_id());
            preparedStatement.setInt(11, service.getService_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int service_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE);
            preparedStatement.setInt(1, service_id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Service> search(String service_name) {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SERVICE);
            preparedStatement.setString(1, "%" + service_name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int service_id = resultSet.getInt("service_id");
                String _service_name = resultSet.getString("service_name");
                double service_area = resultSet.getDouble("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                Service service = new Service(service_id, _service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
                serviceList.add(service);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }
}
