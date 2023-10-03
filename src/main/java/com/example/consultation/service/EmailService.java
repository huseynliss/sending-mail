package com.example.consultation.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMail(String to, String name, String surname) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Consultation registration");
            mimeMessageHelper.setText("Dear " + name + " "+ surname + ", your consultation registration has been completed successfully.");

            javaMailSender.send(mimeMessage);

            return "Mail sent successfully.";

        } catch (Exception e) {
            throw new RuntimeException("Failed to send mail: " + e.getMessage(), e);
        }
    }
}