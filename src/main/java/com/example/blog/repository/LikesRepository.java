package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.models.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long>{
    List<Likes> findByLikedBlog_BlogId(Long blogId);
}
