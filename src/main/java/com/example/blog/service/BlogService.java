package com.example.blog.service;


import java.util.List;

import com.example.blog.models.Blog;

public interface BlogService {
    public String createBlogPost(Blog blog);
    public String updateBlogPost(Blog blog);
    public String deleteBlogPost(String blogPostId);
    public Blog getBlogPost(String blogPostId);
    public List<Blog> getAllBlogPosts();
}
