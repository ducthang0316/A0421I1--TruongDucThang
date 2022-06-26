package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerUseServiceRepository;
import model.repository.impl.CustomerUseServiceRepositoryImpl;
import model.service.CustomerUseServiceService;

import java.util.List;

public class CustomerUseServiceServiceImpl implements CustomerUseServiceService {
    CustomerUseServiceRepository customerUseServiceRepository = new CustomerUseServiceRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerUseServiceRepository.findAll();
    }
}
