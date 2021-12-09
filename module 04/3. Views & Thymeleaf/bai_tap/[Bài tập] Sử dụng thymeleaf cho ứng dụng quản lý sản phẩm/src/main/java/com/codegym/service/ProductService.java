package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 200, "new", "Apple"));
        products.put(2, new Product(2, "Pc", 500, "new", "ROG"));
        products.put(3, new Product(3, "TV", 400, "new", "Sony"));
        products.put(4, new Product(4, "Car", 900, "new", "BMW"));
        products.put(5, new Product(5, "Bike", 800, "new", "Honda"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public int autoIncrease() {
        return products.size() + 1;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().equals(name)){
               result.add(entry.getValue());
            }
        }
        return result;
    }
}
