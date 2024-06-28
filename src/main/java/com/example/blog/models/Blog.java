package com.example.blog.models;

import com.example.blog.exception.BlogValidationException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="blog-post")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    @NotBlank(message="Blog title is required")
    @Size(max=255, message="Blog title must be less than 255 words")
    @Column(nullable=false, unique=false, length=255)
    private String blogTitle;
    
    @NotBlank(message = "Blog body is required")
    @Column(columnDefinition = "TEXT", nullable=false, unique=false)
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

    public void validateFields() throws BlogValidationException {
        if (blogTitle == null || blogTitle.trim().isEmpty()) {
            throw new BlogValidationException("Blog title is required");
        }
        if (blogTitle.length() > 255) {
            throw new BlogValidationException("Blog title must be less than 255 characters");
        }
        if (blogBody == null || blogBody.trim().isEmpty()) {
            throw new BlogValidationException("Blog body is required");
        }
    }
    
}
