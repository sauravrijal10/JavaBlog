package com.example.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.models.Blog;
import com.example.blog.service.BlogService;



@RestController
@RequestMapping("/Blog")
public class BlogPostApi {
    BlogService blogService;

    public BlogPostApi(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("{blogPostId}")
    public Blog getBlogPostDetails(@PathVariable("blogPostId") Long blogPostId) {
        return blogService.getBlogPost(blogPostId);
    }
    @PostMapping("")
    public String createBlogPostDetails(@RequestBody Blog blog){
        blogService.createBlogPost(blog);
        return "Blog Post Create Successfully";
    }

    @PutMapping("")
    public String updateBlogPostDetails(@RequestBody Blog blog){
        blogService.updateBlogPost(blog);
        return "Blog post updated Successfully";
    }
    @DeleteMapping("{blogPostId}")
    public String deleteBlogPostDetails(@PathVariable("blogPostId") Long blogPostId){
        blogService.deleteBlogPost(blogPostId);
        return "Cloud Vendor deleted Successfully";
    }

}
