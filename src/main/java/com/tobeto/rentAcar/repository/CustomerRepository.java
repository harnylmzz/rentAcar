package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
