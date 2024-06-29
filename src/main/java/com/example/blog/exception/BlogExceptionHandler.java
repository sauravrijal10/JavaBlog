package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(value={BlogNotFoundException.class})
    public ResponseEntity<Object> handleBlogNotFoundException(BlogNotFoundException blogNotFoundException){
        BlogException blogException = new BlogException(
            blogNotFoundException.getMessage(),
            blogNotFoundException.getCause(),
            HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(blogException, HttpStatus.NOT_FOUND);
    }
}
