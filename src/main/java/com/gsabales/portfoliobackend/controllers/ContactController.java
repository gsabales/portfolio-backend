package com.gsabales.portfoliobackend.controllers;

import com.gsabales.portfoliobackend.models.Email;
import com.gsabales.portfoliobackend.services.EmailService;
import com.gsabales.portfoliobackend.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Glenn Sabales on 2/16/2021
 */
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController implements Loggable {

    private final EmailService emailService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody Email email) {
        emailService.sendEmail(email);
        return ResponseEntity.ok().body(email);
    }
}
