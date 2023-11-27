package com.tobeto.rentAcar.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {


    private int id;

    private int modelYear;

    private String name;

    private double dailyPrice;

    private String plate;

    private String colour;

    private String fuelType;

    private int manufacturingYear;

    private double mileage;

    private double rateOfEngine;
}
