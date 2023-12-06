package com.tobeto.rentAcar.dtos.requests.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    @NotBlank(message = "Country is mandatory")
    @NotNull(message = "Country is mandatory")
    @Size(min = 2, max = 50)
    private String country;

    @NotBlank(message = "City is mandatory")
    @NotNull(message = "City is mandatory")
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank(message = "Street is mandatory")
    @NotNull(message = "Street is mandatory")
    @Size(min = 2, max = 150)
    private String street;

    @Size(min = 2, max = 7)
    private String zipCode;
}
