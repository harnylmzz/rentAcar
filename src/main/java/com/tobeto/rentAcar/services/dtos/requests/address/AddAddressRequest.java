package com.tobeto.rentAcar.services.dtos.requests.address;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    private String country;

    private String city;

    private String street;

    private String zipCode;
}
