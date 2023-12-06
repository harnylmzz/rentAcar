package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:firstName%")
    List<Employee> searchName(String firstName);

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE %:lastName%")
    List<Employee> searchLastName(String lastName);
}
