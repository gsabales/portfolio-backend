package com.gsabales.portfoliobackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmailSetter extends EmailBody{
    private String name;
    private String email;
    private String subject;
    private String message;

    public EmailSetter(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public String name() {
        return "Glenn";
    }

    @Override
    public String content() {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<b>Name: </b>").append(getName()).append("<br>");
        emailBody.append("<b>Email: </b>").append(getEmail()).append("<br>");
        emailBody.append("<b>Subject: </b>").append(getSubject()).append("<br>");
        emailBody.append("<b>Message: </b>").append(getMessage()).append("<br><br>");

        return emailBody.toString();
    }
}
