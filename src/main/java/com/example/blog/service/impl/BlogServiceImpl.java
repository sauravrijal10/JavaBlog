package com.example.blog.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.exception.BlogValidationException;
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
    public String createBlogPost(Blog blog) throws BlogValidationException{
        // blog.validateFields();
        try{
            blogPostRepository.save(blog);
            return "Successfully saved data";
        }
        catch(DataIntegrityViolationException e){
            throw new BlogValidationException("Error saving blog: " + e.getMessage());
        }
    }

    @Override
    public String updateBlogPost(Blog blog){
        blogPostRepository.save(blog);
        return "Successfully updated data";
    }

    @Override
    public String deleteBlogPost(Long blogPostId){
        blogPostRepository.deleteById(blogPostId);
        return "Data deleted successfully";
    }

    @Override
    public Blog getBlogPost(Long blogPostId){
        if(blogPostRepository.findById(blogPostId).isEmpty())
            throw new BlogNotFoundException("Requested blog does not exists");
        return blogPostRepository.findById(blogPostId).get();
    }
    @Override
    public List<Blog> getAllBlogPosts(){
        return blogPostRepository.findAll();
    }
}
    