package com.tobeto.rentAcar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "name")
    private String name;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "plate")
    private String plate;

    @Column(name = "colour")
    private String colour;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "manufacturing_year")
    private int manufacturingYear;

    @Column(name = "mileage")
    private double mileage;

    @Column(name = "rate_of_engine")
    private double rateOfEngine;

    @OneToMany(mappedBy = "car")
    private List<RentalAgreement> rentalAgreements;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Insurance> insurances;

}
