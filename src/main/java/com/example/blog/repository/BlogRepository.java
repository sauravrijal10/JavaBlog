package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{
    
}
