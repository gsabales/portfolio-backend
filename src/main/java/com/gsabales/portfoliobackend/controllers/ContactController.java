package com.gsabales.portfoliobackend.controllers;

import com.gsabales.portfoliobackend.models.Email;
import com.gsabales.portfoliobackend.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Glenn Sabales on 2/16/2021
 */
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<?> create() throws Exception {
        emailService.sendEmail();
        return ResponseEntity.ok().body("Email testing...");
    }
}
