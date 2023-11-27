package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.DeleteCustomerRequest;
import com.tobeto.rentAcar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentAcar.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetCustomerListResponse> getAll();

    GetCustomerResponse getById(int id);

    void add(AddCustomerRequest addCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);

    void delete(DeleteCustomerRequest deleteCustomerRequest);
}
