package com.tobeto.rentAcar.services.dtos.requests.customer;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String nationalityId;

    private String phone;
}
