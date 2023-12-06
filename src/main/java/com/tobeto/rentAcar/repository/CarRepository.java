package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByName(String name);

    List<Car> findByModelYear(int modelYear);

    List<Car> findByNameContaining(String name);

    @Query("SELECT c FROM Car c WHERE c.name LIKE %:name%")
    List<Car> searchName(String name);

    @Query("SELECT c FROM Car c WHERE c.name LIKE %:name%")
    List<Car> searchNameContaining(String name);
}
