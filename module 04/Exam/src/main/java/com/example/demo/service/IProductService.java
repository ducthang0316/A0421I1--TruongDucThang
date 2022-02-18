package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<Product> findByNameContaining(String name);

    void save(Product product);

    Product findById(Long id);

    void delete(Long id);
}

