package com.gsabales.portfoliobackend.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Email {
    private String name;
    private String email;
    private String subject;
    private String message;
}
