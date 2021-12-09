package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    boolean save(Product product);

    boolean delete(int id);

    boolean update(int id, Product product);

    List<Product> search(String name);
}
