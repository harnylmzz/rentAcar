package com.tobeto.rentAcar.dtos.requests.employee;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String email;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 12)
    private String password;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    private String nationalityId;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    private String phone;
}
