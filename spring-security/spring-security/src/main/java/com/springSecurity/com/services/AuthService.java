package com.springSecurity.com.services;

import com.springSecurity.com.dto.SignupRequest;
import com.springSecurity.com.entities.Customer;

public interface AuthService {
    Customer createCustomer(SignupRequest signupRequest);
}
