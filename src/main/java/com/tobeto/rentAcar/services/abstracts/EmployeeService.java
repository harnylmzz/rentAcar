package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.DeleteEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<GetEmployeeListResponse> getAll();

    GetEmployeeResponse getById(int id);

    void add(AddEmployeeRequest addEmployeeRequest);

    void update(UpdateEmployeeRequest updateEmployeeRequest);

    void delete(DeleteEmployeeRequest deleteEmployeeRequest);

    List<GetEmployeeListResponse> findByFirstName(String firstName);

    List<GetEmployeeListResponse> findByLastName(String lastName);

    List<GetEmployeeListResponse> searchName(String firstName);

    List<GetEmployeeListResponse> searchLastName(String lastName);
}
