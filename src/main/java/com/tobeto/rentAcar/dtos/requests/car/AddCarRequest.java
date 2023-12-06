package com.tobeto.rentAcar.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    private int modelYear;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    private double dailyPrice;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String plate;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String colour;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String fuelType;

    private int manufacturingYear;

    private double mileage;

    private double rateOfEngine;
}
