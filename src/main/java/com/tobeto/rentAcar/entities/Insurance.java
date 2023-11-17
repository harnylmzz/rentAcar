package com.tobeto.rentAcar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insurances")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company")
    private String company;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "policy_type")
    private String policyType;

    @Column(name = "policy_start_date")
    private Date policyStartDate;

    @Column(name = "policy_end_date")
    private Date policyEndDate;

    @Column(name = "policy_price")
    private double policyPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

}
