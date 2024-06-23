package com.example.blog.service;

import com.example.blog.models.Likes;

public interface LikesService {
    public String createPostLike(Likes likes);
    public String deletePostLike(Long likesId);
    // public List<Likes> getPostLike(Long likedBlog);
}