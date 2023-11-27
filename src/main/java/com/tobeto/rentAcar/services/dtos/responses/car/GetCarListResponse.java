package com.tobeto.rentAcar.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {


    private int id;

    private int modelYear;

    private String name;

    private double dailyPrice;

    private String plate;

    private String fuelType;
}
