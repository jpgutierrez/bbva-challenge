package com.bbva.challenge.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Value("${geteway.user}")
    private String gatewayUser;

    @Value("${geteway.pwd}")
    private String getGatewayPwd;

    public boolean isAllowedUser(String username, String password) {
        return gatewayUser.toLowerCase().equals(username.toLowerCase()) &&
                getGatewayPwd.toLowerCase().equals(password.toLowerCase());
    }

}
