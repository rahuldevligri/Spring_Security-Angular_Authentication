package com.springSecurity.com.services;

import com.springSecurity.com.dto.SignupRequest;
import com.springSecurity.com.entities.Customer;
import com.springSecurity.com.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection
    @Autowired
    public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Customer createCustomer(SignupRequest signupRequest) {
        //Check if customer already exist
        if (customerRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        //if customer already isn't exist
        // Create a new customer entity
        Customer customer = new Customer();
        //it will get al the values on signupRequest and set the values in customer object....
        // Copy properties from SignupRequest to Customer entity
        BeanUtils.copyProperties(signupRequest,customer);
        //or
        /* BeanUtils done all this three line work in one line

        customer.setEmail(signupRequest.getEmail());
        customer.setName(signupRequest.getName());
        customer.setPassword(signupRequest.getPassword());
         */

        //convert password into Hash form before saving
        // Encode the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        //now invoke the customer Repository save() method to save the customer data
        Customer createdCustomer = customerRepository.save(customer);
        customer.setId(createdCustomer.getId());
        return customer;
    }
}
