package com.springSecurity.com.controllers;

import com.springSecurity.com.dto.AuthenticationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @GetMapping("/auth")
    public AuthenticationResponse hello(){
        return new AuthenticationResponse("Hello from Authorized API request.");
    }
}
