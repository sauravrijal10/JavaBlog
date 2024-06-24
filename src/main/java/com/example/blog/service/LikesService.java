package com.example.blog.service;

import java.util.List;

import com.example.blog.models.Likes;

public interface LikesService {
    public String createPostLike(Likes likes);
    public String deletePostLike(Long likesId);
    public List<Likes> getLikesByBlogId(Long blogId) ;
}