package com.gsabales.portfoliobackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String name;
    private String email;
    private String subject;
    private String message;
}
