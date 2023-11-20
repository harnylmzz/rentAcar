package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
