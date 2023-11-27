package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.AddressService;
import com.tobeto.rentAcar.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.services.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.services.dtos.responses.address.GetAddressResponse;
import com.tobeto.rentAcar.entities.Address;
import com.tobeto.rentAcar.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public void add(@RequestBody AddAddressRequest addAddressRequest) {

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
}



