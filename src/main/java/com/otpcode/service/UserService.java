package com.otpcode.service;

import com.otpcode.entity.User;
import com.otpcode.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    public User registerUser(User user) {
        return userRepositoty.save(user);
    }
}
