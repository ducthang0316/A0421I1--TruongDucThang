package com.example.bt_bai_7.service;

import com.example.bt_bai_7.model.Blog;
import com.example.bt_bai_7.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save (Category category);

    void remove(Category category);
}
