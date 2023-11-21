package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.entities.Employee;
import com.tobeto.rentAcar.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
@RestController
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/getall")
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/getById")
    public Employee getById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employee.getId()));

        employee.setId(employee.getId());
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmail(employee.getEmail());
        employee.setNationalityId(employee.getNationalityId());
        employee.setPassword(employee.getPassword());
        employee.setPhone(employee.getPhone());

        employeeRepository.save(employee);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
