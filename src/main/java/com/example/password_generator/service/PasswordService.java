package com.example.password_generator.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class PasswordService {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public String generatePassword(int length, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder characterPool = new StringBuilder(UPPERCASE + LOWERCASE);
        if (includeNumbers) characterPool.append(NUMBERS);
        if (includeSpecialChars) characterPool.append(SPECIAL_CHARACTERS);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }
}
