package com.example.bt_bai_7.service;

import com.example.bt_bai_7.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BlogService {

    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllBlogByTitle(Pageable pageable, String title);

    Page<Blog> findAllByCategoryId(Pageable pageable, long id);

//    Object findById(Long id);

    Optional<Blog> findById(Long id);

    void save (Blog blog);

    void remove(Blog blog);
}
