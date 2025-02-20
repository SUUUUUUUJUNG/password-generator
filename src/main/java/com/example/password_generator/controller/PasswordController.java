package com.example.password_generator.controller;

import com.example.password_generator.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/generate")
    public String generatePassword(
            @RequestParam int length,
            @RequestParam boolean includeNumbers,
            @RequestParam boolean includeSpecialChars) {
        return passwordService.generatePassword(length, includeNumbers, includeSpecialChars);
    }
}
