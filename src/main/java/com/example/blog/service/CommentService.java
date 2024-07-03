package com.example.blog.service;

import com.example.blog.exception.BlogValidationException;
import com.example.blog.models.Comments;

public interface CommentService {
    public String createComment(Comments comment) throws BlogValidationException;
    public String updateComment(Comments comment);
    public String deleteComment(Long commentId);
    // public Comments getComment()
}
