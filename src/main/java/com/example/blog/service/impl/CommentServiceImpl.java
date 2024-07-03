package com.example.blog.service.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.blog.exception.BlogValidationException;
import com.example.blog.models.Comments;
import com.example.blog.repository.CommentRepository;
import com.example.blog.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService{
    CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public String createComment(Comments comment) throws BlogValidationException{
        try{
            commentRepository.save(comment);
            return "Successfully saved data";
        }
        catch(DataIntegrityViolationException e){
            throw new BlogValidationException("Error saving comment: " + e.getMessage());
        }
    }
}
