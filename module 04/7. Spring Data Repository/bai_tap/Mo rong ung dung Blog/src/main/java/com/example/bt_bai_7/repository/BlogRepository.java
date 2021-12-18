package com.example.bt_bai_7.repository;

import com.example.bt_bai_7.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
