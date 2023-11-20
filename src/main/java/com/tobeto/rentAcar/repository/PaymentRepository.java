package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
