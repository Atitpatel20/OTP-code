package com.otpcode.controller;

import com.otpcode.entity.User;
import com.otpcode.service.EmailService;
import com.otpcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    @PostMapping("/register")
    public Map<String ,String>registerUser(@RequestBody User user){
        // Register the user without email verification
        User registerUser= userService.registerUser(user);
        return null;
    }
}
