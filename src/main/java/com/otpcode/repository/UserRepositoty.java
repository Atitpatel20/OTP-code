package com.otpcode.repository;

import com.otpcode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoty extends JpaRepository<User,Long> {
    boolean findByEmail(String email);
}
