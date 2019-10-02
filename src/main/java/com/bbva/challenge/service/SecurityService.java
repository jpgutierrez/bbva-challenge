package com.bbva.challenge.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean isAllowedUser(String username, String password) {
        return "user".equals(username.toLowerCase()) &&
                "1234".equals(password.toLowerCase());
    }

}
