package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.blog.exception.BlogValidationException;
import com.example.blog.models.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.utils.JWTUtils;
import com.example.blog.utils.PasswordUtils;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(Long userId,String name,String email, String password) throws BlogValidationException{
        try{
            String hashedpassword = PasswordUtils.hashPassword(password);
            User user = new User(userId, name, email, hashedpassword);
            userRepository.save(user);
        } catch(DataIntegrityViolationException e){
            throw new BlogValidationException("Error creating user: " + e.getMessage());
        }
    }

    public String loginUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user!=null){
            String hashedpassowrd = user.getPassword();
            if(PasswordUtils.verifyPassword(password, hashedpassowrd)){
                return JWTUtils.generateToken(email);
            }
        }
        return null;
    }
    public User getUserDetailsByEmail(String email) {
        return userRepository.findByEmail(email); // Assume you have a method in UserRepository
    }
}   
