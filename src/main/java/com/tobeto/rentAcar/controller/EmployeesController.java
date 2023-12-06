package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.EmployeeService;
import com.tobeto.rentAcar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.DeleteEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
@RestController
@AllArgsConstructor
public class EmployeesController {

    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetEmployeeListResponse> employees() {

        return this.employeeService.getAll();
    }

    @GetMapping("/getbyid")
    public GetEmployeeResponse getById(int id) {

        return this.employeeService.getById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddEmployeeRequest addEmployeeRequest) {

        this.employeeService.add(addEmployeeRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {

        this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        this.employeeService.delete(deleteEmployeeRequest);

    }

    @GetMapping("/findbyfirstname")
    public List<GetEmployeeListResponse> findByFirstName(@RequestParam String firstName) {
        return this.employeeService.findByFirstName(firstName);
    }

    @GetMapping("/findbylastname")
    public List<GetEmployeeListResponse> findByLastName(@RequestParam String lastName) {
        return this.employeeService.findByLastName(lastName);
    }

    @GetMapping("/searchname")
    public List<GetEmployeeListResponse> searchName(@RequestParam String firstName) {
        return this.employeeService.searchName(firstName);
    }

    @GetMapping("/searchlastname")
    public List<GetEmployeeListResponse> searchLastName(@RequestParam String lastName) {
        return this.employeeService.searchLastName(lastName);
    }
}
