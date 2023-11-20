package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
