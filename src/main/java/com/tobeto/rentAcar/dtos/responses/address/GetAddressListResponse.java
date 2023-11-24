package com.tobeto.rentAcar.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressListResponse {

    private int id;

    private String country;

    private String city;
}
