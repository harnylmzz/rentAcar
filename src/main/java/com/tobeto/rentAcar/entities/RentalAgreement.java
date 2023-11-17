package com.tobeto.rentAcar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental_agreements")
public class RentalAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "agreement_date")
    private Date agreementDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "additional_services")
    private String additionalServices;

    @Column(name = "terms_and_conditions")
    private String termsAndConditions;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

}
