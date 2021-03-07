package com.gsabales.portfoliobackend.services;

import com.gsabales.portfoliobackend.models.Email;
import com.gsabales.portfoliobackend.models.EmailSetter;
import com.gsabales.portfoliobackend.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Glenn Sabales on 2/16/2021
 */

@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.yml")
public class EmailService implements Loggable {

    @Value("${gmail.app.username}")
    private String username;
    @Value("${gmail.app.password}")
    private String password;

    public Email sendEmail(final Email email) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        try {
            Message msg = new MimeMessage(session);
            EmailSetter emailSetter = new EmailSetter(email.getName(), email.getEmail(), email.getSubject(), email.getMessage());
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("glenn.sabales@gmail.com"));
            msg.setSubject(emailSetter.getSubject());
            msg.setContent(emailSetter.getBody(), "text/html");

            Transport.send(msg);
            return email;
        } catch (MailException | MessagingException e) {
            System.out.println("Exception caught: " + e.getLocalizedMessage());
            return null;
        }

    }

}
