package com.example.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="blog-post")
public class Blog {

    @Id
    private String blogId;
    private String blogTitle;
    private String blogBody;

    public Blog() {
    }

    public Blog(String blogBody, String blogId, String blogTitle) {
        this.blogBody = blogBody;
        this.blogId = blogId;
        this.blogTitle = blogTitle;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
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
