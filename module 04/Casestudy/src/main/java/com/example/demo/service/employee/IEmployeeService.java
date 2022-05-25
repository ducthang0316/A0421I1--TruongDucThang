package com.example.demo.service.employee;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(Long id);

    void delete(Long id);
}
