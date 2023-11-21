package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.entities.Customer;
import com.tobeto.rentAcar.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@RestController
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/getall")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/getById")
    public Customer getById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @PostMapping("/add")
    public void add(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @PutMapping("/update")
    public void uptade(@RequestBody Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customer.getId()));

        customer.setId(customer.getId());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setNationalityId(customer.getNationalityId());
        customer.setEmail(customer.getEmail());
        customer.setPassword(customer.getPassword());
        customer.setPhone(customer.getPhone());

        customerRepository.save(customer);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
