package com.example.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.models.User;
import com.example.blog.service.UserService;




@RestController
@RequestMapping("/api/user")
public class UserApi {
    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }
    // @GetMapping("{userId}")
    // public User getUserDetails(@PathVariable("userId") String userId){
    //     return userService.
    // }
    @PostMapping("/register")
    public String createUserDetails(@RequestBody User user){
        userService.registerUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
        return "User created successfully";
    }
    @PostMapping("/login")
    // public ResponseEntity<String> loginUser(@RequestParam("email") String email,@RequestParam("password") String password){
    public ResponseEntity<String> loginUser(@RequestBody User user){

        String email = user.getEmail();
        String password = user.getPassword();

        boolean isAuthenticated = userService.loginUser(email, password);
        
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    
    
}
