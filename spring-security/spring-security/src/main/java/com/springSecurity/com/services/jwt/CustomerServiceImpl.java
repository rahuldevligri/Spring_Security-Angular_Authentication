package com.springSecurity.com.services.jwt;

import com.springSecurity.com.entities.Customer;
import com.springSecurity.com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomerServiceImpl implements UserDetailsService {
    //inject Customer repository
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //logic to fetch customer from DB
        //create object of Customer class and invoke findByEmail() method of customerRepository class
        //and pass email that we'll get from loadUserByUsername() method argument.
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));

        return new User(customer.getEmail(), customer.getPassword(), Collections.emptyList());
    }
}
