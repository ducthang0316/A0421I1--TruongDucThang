package model.service;

import model.bean.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    List<Contract> findAll();

    Map<String, String> save(Contract contract);

    Contract findById(int id);

    boolean update(Contract contract, int contract_id);

    boolean delete(int contract_id);

    List<Contract> search(String employee, String customer, String service);
}
