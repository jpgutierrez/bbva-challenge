package com.bbva.challenge.controller;

import com.bbva.challenge.security.JwtTokenUtil;
import com.bbva.challenge.service.SecurityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Auth")
@RestController
@RequestMapping(value = "/auth")
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/token")
    String getToken(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        if (securityService.isAllowedUser(username, pwd)) {
            return jwtTokenUtil.getJWTToken(username);
        }
        return "";
    }

}
