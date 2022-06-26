package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
            public Page<Customer> findAllByAddressContainingAndNameContaining(Pageable pageable, String address, String name) {
        return customerRepository.findAllByAddressContainingAndNameContaining(pageable, address, name);
    }


    @Override
    public Page<Customer> findAllByCustomerTypeId(Pageable pageable, Long id) {
        return customerRepository.findAllByCustomerTypeId(pageable, id);
    }


    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
