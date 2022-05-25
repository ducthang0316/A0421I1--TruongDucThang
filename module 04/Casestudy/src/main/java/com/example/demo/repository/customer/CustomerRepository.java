package com.example.demo.repository.customer;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findByNameContains(Pageable pageable,String name);

    Page<Customer> findAllByAddressContainingAndNameContaining(Pageable pageable,String address, String Name);


    @Query(value ="select * from customer join customer_type where customer.customer_type_id = customer_type.id and customer_type.id = :id"
            , nativeQuery = true)
    Page<Customer> findAllByCustomerTypeId (Pageable pageable, @Param("id") Long id);



}
