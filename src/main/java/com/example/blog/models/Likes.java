package com.example.blog.models;

import com.example.blog.exception.BlogValidationException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="postLikes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="userId", nullable=false)
    private User likedBy;

    @ManyToOne
    @JoinColumn(name="blog_id", referencedColumnName="blogId", nullable=false)
    private Blog likedBlog;

    public Likes() {
    }

    public Likes(Long likesId, User likedBy, Blog likedBlog) {
        this.likesId = likesId;
        this.likedBy = likedBy;
        this.likedBlog = likedBlog;
    }

    public Long getLikesId() {
        return likesId;
    }

    public void setLikesId(Long likesId) {
        this.likesId = likesId;
    }

    public User getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(User likedBy) {
        this.likedBy = likedBy;
    }

    public Blog getLikedBlog() {
        return likedBlog;
    }

    public void setLikedBlog(Blog likedBlog) {
        this.likedBlog = likedBlog;
    }
    public void validateFields() throws BlogValidationException {
        if (likedBy == null) {
            throw new BlogValidationException("likedBy is required");
        }
        if (likedBlog == null) {
            throw new BlogValidationException("likedBlog is required");
        }
    }
}