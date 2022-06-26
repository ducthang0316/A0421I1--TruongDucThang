package model.repository.impl;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_CONTRACT_DETAIL = "SELECT * FROM contract_detail join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;";
    private final String INSERT_INTO_CONTRACT_DETAIL = "INSERT INTO contract_detail(contract_detail_id, contract_id, attach_service_id, quantity) VALUES (?,?,?,?);";
    private final String SELECT_CONTRACT_DETAIL_BY_ID = "SELECT * FROM contract_detail WHERE contract_detail_id = ?;";
    private final String UPDATE_CONTRACT_DETAIL = "UPDATE contract_detail SET contract_id = ?, attach_service_id = ?, quantity = ? WHERE contract_detail_id = ?;";
    private final String DELETE_CONTRACT_DETAIL = "DELETE FROM contract_detail WHERE contract_detail_id = ?;";
    private final String SEARCH_CONTRACT_DETAIL = "SELECT * FROM contract_detail join contract on contract.contract_id = contract_detail.contract_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id WHERE attach_service_name like ? and quantity like ?;";

    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");

                String attach_service_name = resultSet.getString("attach_service_name");
                AttachService attachService = new AttachService(attach_service_name);
                ContractDetail contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity, attachService);
                contractDetailList.add(contractDetail);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public boolean save(ContractDetail contractDetail) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContract_detail_id());
            preparedStatement.setInt(2, contractDetail.getContract_id());
            preparedStatement.setInt(3, contractDetail.getAttach_service_id());
            preparedStatement.setInt(4, contractDetail.getQuantity());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ContractDetail findById(int id) {
        ContractDetail contractDetail = null;
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contractDetail;
    }

    @Override
    public boolean update(ContractDetail contractDetail, int contract_detail_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContract_id());
            preparedStatement.setInt(2, contractDetail.getAttach_service_id());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            preparedStatement.setInt(4, contractDetail.getContract_detail_id());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int contract_detail_id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contract_detail_id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<ContractDetail> search(String attachService, String quantity) {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CONTRACT_DETAIL);
            preparedStatement.setString(1,"%" + attachService + "%");
            if (quantity.equals("")){
                preparedStatement.setString(2, "%");
            }else {
                preparedStatement.setString(2, quantity);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int _quantity = resultSet.getInt("quantity");

                String attach_service_name = resultSet.getString("attach_service_name");
                AttachService _attachService = new AttachService(attach_service_name);
                ContractDetail contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, _quantity, _attachService);
                contractDetailList.add(contractDetail);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contractDetailList;
    }
}
