package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.models.Comments;

public interface  CommentRepository extends JpaRepository<Comments, Long>{
    
}
