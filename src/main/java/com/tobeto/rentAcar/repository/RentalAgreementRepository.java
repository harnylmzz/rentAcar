package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Integer> {
}
