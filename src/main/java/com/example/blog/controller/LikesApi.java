package com.example.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.exception.BlogValidationException;
import com.example.blog.models.Blog;
import com.example.blog.models.Likes;
import com.example.blog.models.User;
import com.example.blog.service.LikesService;



@RestController
@RequestMapping("likes")

public class LikesApi {
    LikesService likesService;

    public LikesApi(LikesService likesService) {
        this.likesService = likesService;
    }

    // @PostMapping("")
    // public String createPostLike(@RequestBody Likes likes){
    //     try{
    //     likesService.createPostLike(likes);
    //     return "Liked blog post";
    //     } catch(BlogValidationException e){
    //         return "Error:" + e.getMessage();
    //     }
    // }
    @PostMapping("")
public ResponseEntity<?> createPostLike(@RequestBody Map<String, Long> request) {
    Long blogId = request.get("likedBlog");
    Long userId = request.get("likedBy");
    
    if (blogId == null || userId == null) {
        return ResponseEntity.badRequest().body("Error: likedBlog and likedBy are required");
    }

    try {
        Likes likes = new Likes();
        
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        likes.setLikedBlog(blogId);
        
        User user = new User();
        user.setUserId(userId);
        likes.setLikedBy(user);

        likesService.createPostLike(likes);
        return ResponseEntity.ok("Liked blog post");
    } catch (BlogValidationException e) {
        return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }
}
    @DeleteMapping("{likesId}")
    public String deletePostLike(@PathVariable("likesId") Long likesId){
        likesService.deletePostLike(likesId);
        return "removed like from post";
    }
    @GetMapping("/blog-likes")
    public ResponseEntity<List<Likes>> getLikesByBlogId(@RequestParam Long blogId) {
        List<Likes> likes = likesService.getLikesByBlogId(blogId);
        return ResponseEntity.ok(likes);
    }
    // @GetMapping("{likedBlog}")
    // public List<Likes> getPostLike(@PathVariable("likedBlog") Long likedBlog){
    //     return likesService.getPostLike(likedBlog);
    // }

}