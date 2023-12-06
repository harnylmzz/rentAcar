package com.tobeto.rentAcar.dtos.requests.customer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Email
    @NotBlank
    @NotNull
    private String email;


    @NotBlank
    @NotNull
    @Size(min = 6, max = 12)
    private String password;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    private String nationalityId;

    private String phone;
}
