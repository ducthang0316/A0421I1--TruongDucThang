package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    boolean save(Customer customer);

    Customer findById(int id);

    boolean update(Customer customer, int id);

    boolean delete(int id);

    List<Customer> search(String customer_name, String customer_address);
}
