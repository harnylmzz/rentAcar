package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
