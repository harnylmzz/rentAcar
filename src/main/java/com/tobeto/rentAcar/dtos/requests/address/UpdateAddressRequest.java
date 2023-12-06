package com.tobeto.rentAcar.dtos.requests.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {

    private int id;

    private String country;

    private String city;

    private String street;

    private String zipCode;
}
