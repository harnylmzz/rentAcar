package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE %:firstName%")
    List<Customer> searchName(String firstName);

    @Query("SELECT c FROM Customer c WHERE c.lastName LIKE %:lastName%")
    List<Customer> searchLastName(String lastName);

    boolean existsByEmail(String email);

    boolean existsByNationalityId(String nationalityId);

}
