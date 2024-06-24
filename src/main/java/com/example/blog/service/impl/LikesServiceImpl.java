package com.example.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public String createPostLike(Likes likes){
        likesRepository.save(likes);
        return "Liked post";
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