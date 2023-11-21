package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
