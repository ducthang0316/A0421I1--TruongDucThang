package model.repository;

import model.bean.Contract;
import model.bean.Service;

import java.util.List;

public interface ContractRepository {
    List<Contract> findAll();

    boolean save(Contract contract);

    Contract findById(int id);

    boolean update(Contract contract, int contract_id);

    boolean delete(int contract_id);

    List<Contract> search(String employee, String customer, String service);
}
