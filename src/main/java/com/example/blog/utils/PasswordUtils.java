package com.example.blog.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    public static String hashPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }
    public static boolean verifyPassword(String password, String hashedpassword){
        return BCrypt.checkpw(password, hashedpassword);
    }
}
