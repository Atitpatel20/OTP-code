package com.otpcode.controller;

import com.otpcode.entity.User;
import com.otpcode.service.EmailService;
import com.otpcode.service.EmailVerificationService;
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

    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody User user) {
        // Register the user without email verification
        User registeredUser = userService.registerUser(user);
        Map<String, String> response = emailService.sendOtpEmail(user.getEmail());
        return response;
    }

    @PostMapping("/verify-otp")
    public Map<String, String> verifyOtp(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String otp = requestBody.get("otp");

        Map<String, String> response = emailVerificationService.verifyOtp(email, otp);
        return response;
    }
}
