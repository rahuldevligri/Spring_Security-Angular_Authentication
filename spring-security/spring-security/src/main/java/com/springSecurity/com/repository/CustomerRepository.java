package com.springSecurity.com.repository;

import com.springSecurity.com.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//JPA is a java presistent API which is intract with data base that how to store and get data that is come form APIs.
// it is provide basis level build in method save(), saveAll(), findById(), deleteById etc...
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
