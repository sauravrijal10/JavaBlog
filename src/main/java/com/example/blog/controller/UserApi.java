package com.example.blog.controller;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {

        String email = user.getEmail();
        String password = user.getPassword();
        String token = userService.loginUser(email, password);

        // boolean isAuthenticated = userService.loginUser(email, password);
        
        if (token!=null) {
        User authenticatedUser = userService.getUserDetailsByEmail(email);
        
        Map<String, Object> userMap = new HashMap<>();
            userMap.put("id", authenticatedUser.getUserId());
            userMap.put("email", authenticatedUser.getEmail());
            userMap.put("name", authenticatedUser.getName());
        
        Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", userMap);

        return ResponseEntity.ok(response);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
