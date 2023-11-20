package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
