package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
