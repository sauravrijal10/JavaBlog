package com.example.blog.service;


import java.util.List;

import com.example.blog.models.Blog;

public interface BlogService {
    public String createBlogPost(Blog blog);
    public String updateBlogPost(Blog blog);
    public String deleteBlogPost(Long blogPostId);
    public Blog getBlogPost(Long blogPostId);
    public List<Blog> getAllBlogPosts();
}
