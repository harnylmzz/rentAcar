package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.CustomerService;
import com.tobeto.rentAcar.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentAcar.dtos.requests.customer.DeleteCustomerRequest;
import com.tobeto.rentAcar.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentAcar.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentAcar.dtos.responses.customer.GetCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@RestController
@AllArgsConstructor
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("/getall")
    public List<GetCustomerListResponse> getAll() {

        return this.customerService.getAll();
    }

    @GetMapping("/getbyid")
    public GetCustomerResponse getById(int id) {

        return this.customerService.getById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCustomerRequest addCustomerRequest) {

        this.customerService.add(addCustomerRequest);
    }

    @PutMapping("/update")
    public void uptade(@RequestBody UpdateCustomerRequest updateCustomerRequest) {

        this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteCustomerRequest deleteCustomerRequest) {

        this.customerService.delete(deleteCustomerRequest);

    }

    @GetMapping("/findbyfirstname")
    public List<GetCustomerListResponse> findByFirstName(@RequestParam String firstName) {
        return this.customerService.findByFirstName(firstName);
    }

    @GetMapping("/findbylastname")
    public List<GetCustomerListResponse> findByLastName(@RequestParam String lastName) {
        return this.customerService.findByLastName(lastName);
    }

    @GetMapping("/searchname")
    public List<GetCustomerListResponse> searchName(@RequestParam String firstName) {
        return this.customerService.searchName(firstName);
    }

    @GetMapping("/searchlastname")
    public List<GetCustomerListResponse> searchLastName(@RequestParam String lastName) {
        return this.customerService.searchLastName(lastName);
    }
}
