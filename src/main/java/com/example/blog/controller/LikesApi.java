package com.example.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.models.Likes;
import com.example.blog.service.LikesService;




@RestController
@RequestMapping("likes")

public class LikesApi {
    LikesService likesService;

    public LikesApi(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping("")
    public String createPostLike(@RequestBody Likes likes){
        likesService.createPostLike(likes);
        return "Liked blog post";
    }
    @DeleteMapping("{likesId}")
    public String deletePostLike(@PathVariable("likesId") Long likesId){
        likesService.deletePostLike(likesId);
        return "removed like from post";
    }
    // @GetMapping("{likedBlog}")
    // public List<Likes> getPostLike(@PathVariable("likedBlog") Long likedBlog){
    //     return likesService.getPostLike(likedBlog);
    // }

}