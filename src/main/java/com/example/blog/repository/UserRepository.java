package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
