package com.example.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="blog-post")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    private String blogTitle;
    
    private String blogBody;

    public Blog() {
    }

    public Blog(String blogBody, Long blogId, String blogTitle) {
        this.blogBody = blogBody;
        this.blogId = blogId;
        this.blogTitle = blogTitle;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogBody() {
        return blogBody;
    }

    public void setBlogBody(String blogBody) {
        this.blogBody = blogBody;
    }
    
}
