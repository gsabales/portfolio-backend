package com.gsabales.portfoliobackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.AuthenticationFailedException;

/**
 * Created by Glenn Sabales on 2/16/2021
 */

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("glenn.sabales@gmail.com");
            message.setSubject("Test email from local spring boot project");
            message.setText("Let's see if it works again");
            javaMailSender.send(message);
        } catch (MailException e) {
            System.out.println("Exception caught: " + e.getLocalizedMessage());
        }

    }

}
