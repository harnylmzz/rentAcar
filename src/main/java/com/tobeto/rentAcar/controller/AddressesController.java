package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressResponse;
import com.tobeto.rentAcar.entities.Address;
import com.tobeto.rentAcar.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;

    public AddressesController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/getall")
    public List<GetAddressListResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<GetAddressListResponse> responseList = new ArrayList<>();

        for (Address address : addresses) {
            GetAddressListResponse response = new GetAddressListResponse();
            response.setId(address.getId());
            response.setCountry(address.getCountry());
            response.setCity(address.getCity());

            responseList.add(response);
        }

        return responseList;
    }


    @GetMapping("/getbyid")
    public GetAddressResponse getById(int id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        GetAddressResponse getAddressResponse = new GetAddressResponse();

        getAddressResponse.setCountry(address.getCountry());
        getAddressResponse.setCity(address.getCity());

        return getAddressResponse;
    }

    @PostMapping("/add")
    public void add(@RequestBody AddAddressRequest addAddressRequest) {

        Address address = new Address();

        address.setCountry(addAddressRequest.getCountry());
        address.setCity(addAddressRequest.getCity());
        address.setStreet(addAddressRequest.getStreet());
        address.setZipCode(addAddressRequest.getZipCode());

        addressRepository.save(address);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateAddressRequest updateAddressRequest) {

        Address address = addressRepository.findById(updateAddressRequest.getId())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + updateAddressRequest.getId()));

        address.setId(updateAddressRequest.getId());
        address.setCountry(updateAddressRequest.getCountry());
        address.setCity(updateAddressRequest.getCity());
        address.setStreet(updateAddressRequest.getStreet());
        address.setZipCode(updateAddressRequest.getZipCode());

        addressRepository.save(address);

    }

    @DeleteMapping("/delete")
    public DeleteAddressRequest delete(int id) {

        addressRepository.deleteById(id);

        return new DeleteAddressRequest(id);
    }
}



