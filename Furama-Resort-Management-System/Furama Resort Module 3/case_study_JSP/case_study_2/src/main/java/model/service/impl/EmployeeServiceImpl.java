package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean update(Employee employee, int employee_id) {
        return employeeRepository.update(employee, employee_id);
    }

    @Override
    public boolean delete(int employee_id) {
        return employeeRepository.delete(employee_id);
    }

    @Override
    public List<Employee> search(String employee_name, String employee_address) {
        return employeeRepository.search(employee_name, employee_address);
    }
}
