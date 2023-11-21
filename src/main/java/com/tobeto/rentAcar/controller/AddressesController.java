package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.entities.Address;
import com.tobeto.rentAcar.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;

    public AddressesController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/getall")
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @GetMapping("/getById")
    public Address getById(@PathVariable int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    @PostMapping("/add")
    public void add(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @PutMapping("/update")
    public void update(@RequestBody Address address) {

        Address address1 = addressRepository.findById(address.getId())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + address));

        address.setId(address.getId());
        address.setCountry(address.getCountry());
        address.setCity(address.getCity());
        address.setStreet(address.getStreet());
        address.setZipCode(address.getZipCode());

        addressRepository.save(address);

    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}



