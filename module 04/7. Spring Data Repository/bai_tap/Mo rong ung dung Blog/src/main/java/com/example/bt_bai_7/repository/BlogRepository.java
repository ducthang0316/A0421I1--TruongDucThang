package com.example.bt_bai_7.repository;

import com.example.bt_bai_7.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(Pageable pageable, String title);

    @Query(value= "select * from blog join category where blog.category_id = category.id and category.id =:id"
            , nativeQuery = true)
    Page<Blog> findAllByCategoryId(Pageable pageable, @Param("id") long id);
}
