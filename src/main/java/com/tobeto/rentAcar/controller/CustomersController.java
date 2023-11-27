package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.CustomerService;
import com.tobeto.rentAcar.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.DeleteCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public void add(@RequestBody AddCustomerRequest addCustomerRequest) {

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
}
