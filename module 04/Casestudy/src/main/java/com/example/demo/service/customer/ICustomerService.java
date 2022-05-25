package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByAddressContainingAndNameContaining(Pageable pageable, String address, String name);


    Page<Customer> findAllByCustomerTypeId(Pageable pageable, Long id);

    void save(Customer customer);

    Object findById(Long id);

    void delete(Long id);
}
