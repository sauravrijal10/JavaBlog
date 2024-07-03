package com.example.blog.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Comments {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long commentId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="userId", nullable=false)
    private User commentBy;

    @ManyToOne
    @JoinColumn(name="blog_id", referencedColumnName="blogId", nullable=false)
    private User commentBlog;

    @Column(nullable=false, unique=false, length=255)
    private String comment;

    public Comments() {
    }

    public Comments(long commentId, User commentBy, User commentBlog, String comment) {
        this.commentId = commentId;
        this.commentBy = commentBy;
        this.commentBlog = commentBlog;
        this.comment = comment;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public User getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(User commentBy) {
        this.commentBy = commentBy;
    }

    public User getCommentBlog() {
        return commentBlog;
    }

    public void setCommentBlog(User commentBlog) {
        this.commentBlog = commentBlog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
}
