package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Customer;
import com.tobeto.rentAcar.repository.CustomerRepository;
import com.tobeto.rentAcar.services.abstracts.CustomerService;
import com.tobeto.rentAcar.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.DeleteCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentAcar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
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

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();

        getCustomerResponse.setFirstName(customer.getFirstName());
        getCustomerResponse.setLastName(customer.getLastName());

        return getCustomerResponse;
    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {

        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setNationalityId(addCustomerRequest.getNationalityId());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPassword(addCustomerRequest.getPassword());
        customer.setPhone(addCustomerRequest.getPhone());

        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {

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

    @Override
    public void delete(DeleteCustomerRequest deleteCustomerRequest) {
        customerRepository.deleteById(deleteCustomerRequest.getId());
    }
}
