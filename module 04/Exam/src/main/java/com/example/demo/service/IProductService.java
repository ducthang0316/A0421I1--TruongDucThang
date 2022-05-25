package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(Pageable pageable, String name);

    List<Product> findByPrice(int price);

    List<Product> findByProductTypeId(Long type);

    void save(Product product);

    Product findById(Long id);

    void delete(Long id);

    List<Product> findAllByNameContainsAndAndPriceAndAndProductType(String name, int price, Long type);
}

