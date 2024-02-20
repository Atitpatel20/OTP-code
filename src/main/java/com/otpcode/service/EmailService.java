package com.otpcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import static com.otpcode.service.EmailVerificationService.emailOtpMapping;
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private final UserService userService;

    public EmailService(UserService userService) {
        this.userService = userService;
    }
    public String generateOtp() {
        return String.format("%06d", new java.util.Random().nextInt(1000000));
    }
    public void sendOtpEmail(String email) {
        String otp = generateOtp();
        // save otp for later verification
        emailOtpMapping.put(email, otp);
        sendEmail(email, "OTP for Email Verification", "Your OTP is: "+otp);
    }
    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("atitpatel296@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
