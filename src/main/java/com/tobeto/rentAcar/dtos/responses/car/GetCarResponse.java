package com.tobeto.rentAcar.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {

    private int modelYear;

    private String name;

    private double dailyPrice;

    private String plate;

    private String fuelType;
}
