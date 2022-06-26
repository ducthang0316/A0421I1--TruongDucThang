package model.service.impl;

import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;
import model.repository.impl.ContractDetailRepositoryImpl;
import model.service.ContractDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Map<String, String> save(ContractDetail contractDetail) {
        Map<String, String> contractDetailMap = new HashMap<>();
        boolean check = true;

        // contract detail
        if (contractDetail.getQuantity() == -1){
            check = false;
            contractDetailMap.put("quantityMessage", "Quantity can not be empty!");
        }else if (contractDetail.getQuantity() == -3){
            check = false;
            contractDetailMap.put("quantityMessage", "Quantity is not a number!");
        }else if (contractDetail.getQuantity() == 0){
            check = false;
            contractDetailMap.put("quantityMessage", "Quantity can not be zero!");
        }else if (contractDetail.getQuantity() < 0){
            check = false;
            contractDetailMap.put("quantityMessage", "Quantity can not be less then zero!");
        }

        if (check){
            contractDetailRepository.save(contractDetail);
        }

        return contractDetailMap;
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public boolean update(ContractDetail contractDetail, int contract_detail_id) {
        return contractDetailRepository.update(contractDetail, contract_detail_id);
    }

    @Override
    public boolean delete(int contract_detail_id) {
        return contractDetailRepository.delete(contract_detail_id);
    }

    @Override
    public List<ContractDetail> search(String attachService, String quantity) {
        return contractDetailRepository.search(attachService, quantity);
    }
}
