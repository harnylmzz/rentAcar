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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "method")
    private String method;

    @Column(name = "details")
    private String details;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Customer customer;

}
