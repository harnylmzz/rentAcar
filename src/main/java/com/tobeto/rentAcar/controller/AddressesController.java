package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.AddressService;
import com.tobeto.rentAcar.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private AddressService addressService;

    @GetMapping("/getall")
    public List<GetAddressListResponse> getAll() {
        return this.addressService.getAll();
    }

    @GetMapping("/getbyid")
    public GetAddressResponse getById(int id) {

        return this.addressService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddAddressRequest addAddressRequest) {

        this.addressService.add(addAddressRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateAddressRequest updateAddressRequest) {

        this.addressService.update(updateAddressRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteAddressRequest deleteAddressRequest) {

        this.addressService.delete(deleteAddressRequest);
    }

    @GetMapping("/findbycountry")
    public List<GetAddressListResponse> findByCountry(@RequestParam String name) {
        return this.addressService.findByCountry(name);
    }

    @GetMapping("/findbycity")
    public List<GetAddressListResponse> findByCity(@RequestParam String name) {
        return this.addressService.findByCity(name);
    }

    @GetMapping("/searchcountry")
    public List<GetAddressListResponse> searchCountry(@RequestParam String name) {
        return this.addressService.searchCountry(name);
    }

    @GetMapping("/searchcity")
    public List<GetAddressListResponse> searchCity(@RequestParam String name) {
        return this.addressService.searchCity(name);
    }
}



