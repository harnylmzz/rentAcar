package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Employee;
import com.tobeto.rentAcar.repository.EmployeeRepository;
import com.tobeto.rentAcar.services.abstracts.EmployeeService;
import com.tobeto.rentAcar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.DeleteEmployeeRequest;
import com.tobeto.rentAcar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentAcar.dtos.responses.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<GetEmployeeListResponse> getAll() {
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

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

        getEmployeeResponse.setFirstName(employee.getFirstName());
        getEmployeeResponse.setLastName(employee.getLastName());

        return getEmployeeResponse;
    }

    @Override
    public void add(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = new Employee();

        employee.setFirstName(addEmployeeRequest.getFirstName());
        employee.setLastName(addEmployeeRequest.getLastName());
        employee.setEmail(addEmployeeRequest.getEmail());
        employee.setNationalityId(addEmployeeRequest.getNationalityId());
        employee.setPassword(addEmployeeRequest.getPassword());
        employee.setPhone(addEmployeeRequest.getPhone());

        employeeRepository.save(employee);
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {

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

    @Override
    public void delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        employeeRepository.deleteById(deleteEmployeeRequest.getId());

    }

    @Override
    public List<GetEmployeeListResponse> findByFirstName(String firstName) {

        List<Employee> employees = employeeRepository.findByFirstName(firstName);
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

    @Override
    public List<GetEmployeeListResponse> findByLastName(String lastName) {

        List<Employee> employees = employeeRepository.findByLastName(lastName);
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

    @Override
    public List<GetEmployeeListResponse> searchName(String firstName) {

        List<Employee> employees = employeeRepository.searchName(firstName);
        List<GetEmployeeListResponse> responseList = new ArrayList<>();

        for (Employee employee : employees) {
            responseList.add(new GetEmployeeListResponse(employee.getId(),
                    employee.getFirstName(), employee.getLastName()));

        }
        return responseList;
    }

    @Override
    public List<GetEmployeeListResponse> searchLastName(String lastName) {

        List<Employee> employees = employeeRepository.searchLastName(lastName);
        List<GetEmployeeListResponse> responseList = new ArrayList<>();

        for (Employee employee : employees) {
            responseList.add(new GetEmployeeListResponse(employee.getId(),
                    employee.getFirstName(), employee.getLastName()));
        }
        return responseList;
    }
}
