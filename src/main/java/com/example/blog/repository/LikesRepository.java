package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.models.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long>{
    // List<Likes> findByLikedBlog(Long likedBlog);;
}
