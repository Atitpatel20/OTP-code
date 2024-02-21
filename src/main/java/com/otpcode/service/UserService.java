package com.otpcode.service;

import com.otpcode.entity.User;
import com.otpcode.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositoty userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }
}
