package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByNameContaining(Pageable pageable, String name) {
        return productRepository.findByNameContaining(pageable, name);
    }

    @Override
    public List<Product> findByPrice(int price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findByProductTypeId(Long type) {
        return productRepository.findByProductTypeId(type);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByNameContainsAndAndPriceAndAndProductType( String name, int price, Long type) {
        return productRepository.findAllByNameContainsAndAndPriceAndAndProductType(name, price, type);
    }

}
