package com.tobeto.rentAcar.repository;

import com.tobeto.rentAcar.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {


    List<Address> findByCountry(String country);

    List<Address> findByCity(String city);

    @Query("SELECT a FROM Address a WHERE a.country LIKE %:country%")
    List<Address> searchCountry(String country);

    @Query("SELECT a FROM Address a WHERE a.city LIKE %:city%")
    List<Address> searchCity(String city);

    boolean existsByCountry(String country);

    boolean existsByCity(String city);
}
