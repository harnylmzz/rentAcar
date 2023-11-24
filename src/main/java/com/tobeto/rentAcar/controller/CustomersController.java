package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentAcar.dtos.requests.customer.DeleteCustomerRequest;
import com.tobeto.rentAcar.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentAcar.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentAcar.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.rentAcar.entities.Customer;
import com.tobeto.rentAcar.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/customers")
@RestController
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/getall")
    public List<GetCustomerListResponse> getAll() {

        List<Customer> customer = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = new ArrayList<>();

        for (Customer customer1 : customer) {
            GetCustomerListResponse response = new GetCustomerListResponse();

            response.setId(customer1.getId());
            response.setFirstName(customer1.getFirstName());
            response.setLastName(customer1.getLastName());

            responseList.add(response);
        }

        return responseList;
    }

    @GetMapping("/getbyid")
    public GetCustomerResponse getById(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();

        getCustomerResponse.setFirstName(customer.getFirstName());
        getCustomerResponse.setLastName(customer.getLastName());

        return getCustomerResponse;

    }

    @PostMapping("/add")
    public void add(@RequestBody AddCustomerRequest addCustomerRequest) {

        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setNationalityId(addCustomerRequest.getNationalityId());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPassword(addCustomerRequest.getPassword());
        customer.setPhone(addCustomerRequest.getPhone());

        customerRepository.save(customer);
    }

    @PutMapping("/update")
    public void uptade(@RequestBody UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository.findById(updateCustomerRequest.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + updateCustomerRequest.getId()));

        customer.setId(updateCustomerRequest.getId());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setNationalityId(updateCustomerRequest.getNationalityId());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setPassword(updateCustomerRequest.getPassword());
        customer.setPhone(updateCustomerRequest.getPhone());

        customerRepository.save(customer);
    }

    @DeleteMapping("/delete")
    public DeleteCustomerRequest delete(int id) {

        customerRepository.deleteById(id);

        return new DeleteCustomerRequest(id);
    }
}
