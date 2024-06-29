package com.example.blog.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.blog.exception.BlogValidationException;
import com.example.blog.models.Likes;
import com.example.blog.repository.LikesRepository;
import com.example.blog.service.LikesService;


@Service
public class LikesServiceImpl implements LikesService{
    LikesRepository likesRepository;

    public LikesServiceImpl(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }
    @Override
    public String createPostLike(Likes likes) throws BlogValidationException{
        try{
            likesRepository.save(likes);
            return "Liked post";
        } catch(DataIntegrityViolationException e){
            throw new BlogValidationException("Error creating user: " + e.getMessage());
        }
    }
    @Override
    public String deletePostLike(Long likesId){
        likesRepository.deleteById(likesId);
        return "like removed";
    }
    @Override
    public List<Likes> getLikesByBlogId(Long blogId) {
        return likesRepository.findByLikedBlog_BlogId(blogId);
    }

    // @Override
    // public List<Likes> getPostLike(Long likedBlog){
    //     return likesRepository.findByLikedBlog(likedBlog);
    // }   

}