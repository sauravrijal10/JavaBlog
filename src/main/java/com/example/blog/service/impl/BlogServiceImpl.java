package com.example.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog.models.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;

@Service
public class BlogServiceImpl implements  BlogService{
    BlogRepository blogPostRepository;

    public BlogServiceImpl(BlogRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }
    @Override
    public String createBlogPost(Blog blog){
        blogPostRepository.save(blog);
        return "Successfully saved data";
    }

    @Override
    public String updateBlogPost(Blog blog){
        blogPostRepository.save(blog);
        return "Successfully updated data";
    }

    @Override
    public String deleteBlogPost(String blogPostId){
        blogPostRepository.deleteById(blogPostId);
        return "Data deleted successfully";
    }

    @Override
    public Blog getBlogPost(String blogPostId){
        return blogPostRepository.findById(blogPostId).get();
    }
    @Override
    public List<Blog> getAllBlogPosts(){
        return blogPostRepository.findAll();
    }
}
    