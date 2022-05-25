package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(Pageable pageable ,String name);

    List<Product> findByPrice(int price);

    List<Product> findByProductTypeId(Long type);

    List<Product> findAllByNameContainsAndAndPriceAndAndProductType( String name, int price, Long type);
}
