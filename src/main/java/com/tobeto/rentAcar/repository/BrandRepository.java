package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//Generic türler Reference Type olmak zorundadır!!!!!!
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
