package com.example.bt_bai_7.service;

import com.example.bt_bai_7.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BlogService {

    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    void save (Blog blog);

    void remove(Long id);
}
