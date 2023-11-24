package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.DeleteEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeResponse;
import com.tobeto.rentAcar.entities.Employee;
import com.tobeto.rentAcar.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/employees")
@RestController
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/getall")
    public List<GetEmployeeListResponse> employees() {

        List<Employee> employees = employeeRepository.findAll();
        List<GetEmployeeListResponse> responseList = new ArrayList<>();

        for (Employee employee : employees) {

            GetEmployeeListResponse response = new GetEmployeeListResponse();

            response.setId(employee.getId());
            response.setFirstName(employee.getFirstName());
            response.setLastName(employee.getLastName());

            responseList.add(response);
        }

        return responseList;
    }

    @GetMapping("/getbyid")
    public GetEmployeeResponse getById(int id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

        getEmployeeResponse.setFirstName(employee.getFirstName());
        getEmployeeResponse.setLastName(employee.getLastName());

        return getEmployeeResponse;
    }

    @PostMapping("/add")
    public void add(@RequestBody AddEmployeeRequest addEmployeeRequest) {

        Employee employee = new Employee();

        employee.setFirstName(addEmployeeRequest.getFirstName());
        employee.setLastName(addEmployeeRequest.getLastName());
        employee.setEmail(addEmployeeRequest.getEmail());
        employee.setNationalityId(addEmployeeRequest.getNationalityId());
        employee.setPassword(addEmployeeRequest.getPassword());
        employee.setPhone(addEmployeeRequest.getPhone());

        employeeRepository.save(employee);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = employeeRepository.findById(updateEmployeeRequest.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + updateEmployeeRequest.getId()));

        employee.setFirstName(updateEmployeeRequest.getFirstName());
        employee.setLastName(updateEmployeeRequest.getLastName());
        employee.setEmail(updateEmployeeRequest.getEmail());
        employee.setNationalityId(updateEmployeeRequest.getNationalityId());
        employee.setPassword(updateEmployeeRequest.getPassword());
        employee.setPhone(updateEmployeeRequest.getPhone());

        employeeRepository.save(employee);
    }

    @DeleteMapping("/delete")
    public DeleteEmployeeRequest delete(int id) {
        employeeRepository.deleteById(id);

        return new DeleteEmployeeRequest(id);
    }
}
