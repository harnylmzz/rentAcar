package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByName(String name);

    List<Brand> findByNameContaining(String name);

    List<Brand> findByNameStartingWith(String name);

    List<Brand> findByNameEndingWith(String name);

    @Query("SELECT b FROM Brand b WHERE b.name LIKE %:name%")
    List<Brand> searchName(String name);

    @Query("SELECT b FROM Brand b WHERE b.name LIKE %:name%")
    List<Brand> searchNameContaining(String name);

    boolean existsByName(String name);

}
