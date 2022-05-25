package model.service.impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.ContractService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Map<String, String> save(Contract contract) {
        Map<String, String> messageMap = new HashMap<>();
        boolean check = true;

        //deposit validate
        if (contract.getContract_deposit() == 0.001){
            check = false;
            messageMap.put("depositMessage", "Deposit can not be empty!");
        }else if (contract.getContract_deposit() == 0){
            check = false;
            messageMap.put("depositMessage", "Deposit can not be zero!");
        }else if (contract.getContract_deposit() < 0){
            check = false;
            messageMap.put("depositMessage", "Deposit can not be less then zero!");
        }else if (contract.getContract_deposit() == 0.002){
            check = false;
            messageMap.put("depositMessage", "Deposit is not a number!");
        }

        //total money validate
        if (contract.getContract_total_money() == 0.001){
            check = false;
            messageMap.put("totalMoneyMessage", "Total money can not be empty!");
        }else if (contract.getContract_total_money() == 0){
            check = false;
            messageMap.put("totalMoneyMessage", "Total money can not be zero!");
        }else if (contract.getContract_total_money() < 0){
            check = false;
            messageMap.put("totalMoneyMessage", "Total money can not be less then zero!");
        }else if (contract.getContract_total_money() == 2){
            check = false;
            messageMap.put("totalMoneyMessage", "Deposit is not a number!");
        }

        //start date validate
        if (contract.getContract_start_date().equals("")){
            check = false;
            messageMap.put("startDateMessage", "Start date can not be empty!");
        }

        //end date validate
        if (contract.getContract_end_date().equals("")){
            check = false;
            messageMap.put("endDateMessage", "End date can not be empty!");
        }
        if (check){
            contractRepository.save(contract);
        }
        return messageMap;
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public boolean update(Contract contract, int contract_id) {
        return contractRepository.update(contract, contract_id);
    }

    @Override
    public boolean delete(int contract_id) {
        return contractRepository.delete(contract_id);
    }

    @Override
    public List<Contract> search(String employee, String customer, String service) {
        return contractRepository.search(employee, customer, service);
    }
}
