package com.springSecurity.com.controllers;

import com.springSecurity.com.dto.SignupRequest;
import com.springSecurity.com.entities.Customer;
import com.springSecurity.com.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        Customer createdCustomer = authService.createCustomer(signupRequest);
        if (createdCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
        }
    }

}

//import com.springSecurity.com.dto.SignupRequest;
//import com.springSecurity.com.services.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/signup")
//public class SignupController {
//    //1st inject auth service
//    private final AuthService authService;
//
//    //constructor injection
//    @Autowired
//    public SignupController(AuthService authService){
//        this.authService = authService;
//    }
//
//    @PostMapping()
//    public ResponseEntity<String> signupCustomer(@RequestBody SignupRequest signupRequest){
//        boolean isUserCreated = authService.createCustomer(signupRequest);
//        //check user is created or not
//        if(isUserCreated){
//            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create Customer");
//        }
//    }
//}
