package com.example.bt_bai_7.service.impl;

import com.example.bt_bai_7.model.Blog;
import com.example.bt_bai_7.repository.BlogRepository;
import com.example.bt_bai_7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByTitle(Pageable pageable, String title) {
        return blogRepository.findAllByTitleContaining(pageable, title);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Pageable pageable, long id) {
        return blogRepository.findAllByCategoryId(pageable, id);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }
}
