package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Address;
import com.tobeto.rentAcar.repository.AddressRepository;
import com.tobeto.rentAcar.services.abstracts.AddressService;
import com.tobeto.rentAcar.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;


    @Override
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

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        GetAddressResponse getAddressResponse = new GetAddressResponse();
        getAddressResponse.setCountry(address.getCountry());
        getAddressResponse.setCity(address.getCity());

        return getAddressResponse;
    }

    @Override
    public void add(AddAddressRequest addAddressRequest) {

        if (addressRepository.existsByCountry(addAddressRequest.getCountry())) {
            throw new RuntimeException("Country already exists");
        }
        if (addressRepository.existsByCity(addAddressRequest.getCity())) {
            throw new RuntimeException("City already exists");
        }

        Address address = new Address();

        address.setCountry(addAddressRequest.getCountry());
        address.setCity(addAddressRequest.getCity());
        address.setStreet(addAddressRequest.getStreet());
        address.setZipCode(addAddressRequest.getZipCode());

        addressRepository.save(address);
    }

    @Override
    public void update(UpdateAddressRequest updateAddressRequest) {

        Address address = addressRepository.findById(updateAddressRequest.getId())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + updateAddressRequest.getId()));

        address.setId(updateAddressRequest.getId());
        address.setCountry(updateAddressRequest.getCountry());
        address.setCity(updateAddressRequest.getCity());
        address.setStreet(updateAddressRequest.getStreet());
        address.setZipCode(updateAddressRequest.getZipCode());

        addressRepository.save(address);
    }

    @Override
    public void delete(DeleteAddressRequest deleteAddressRequest) {

        addressRepository.deleteById(deleteAddressRequest.getId());

    }

    @Override
    public List<GetAddressListResponse> findByCountry(String name) {

        List<Address> addresses = addressRepository.findByCountry(name);
        List<GetAddressListResponse> responseList = new ArrayList<>();

        for (Address address : addresses) {
            responseList.add(new GetAddressListResponse(address.getId(), address.getCountry(), address.getCity()
            ));
        }


        return responseList;
    }

    @Override
    public List<GetAddressListResponse> findByCity(String name) {

        List<Address> addresses = addressRepository.findByCity(name);
        List<GetAddressListResponse> responseList = new ArrayList<>();

        for (Address address : addresses) {
            responseList.add(new GetAddressListResponse(address.getId(), address.getCountry(), address.getCity()));

        }

        return responseList;
    }

    @Override
    public List<GetAddressListResponse> searchCountry(String name) {

        List<Address> addresses = addressRepository.searchCountry(name);
        List<GetAddressListResponse> responseList = new ArrayList<>();

        for (Address address : addresses) {
            responseList.add(new GetAddressListResponse(address.getId(), address.getCountry(), address.getCity()));
        }

        return responseList;
    }

    @Override
    public List<GetAddressListResponse> searchCity(String name) {

        List<Address> addresses = addressRepository.searchCity(name);
        List<GetAddressListResponse> responseList = new ArrayList<>();

        for (Address address : addresses) {
            responseList.add(new GetAddressListResponse(address.getId(), address.getCountry(), address.getCity()));
        }
        return responseList;
    }
}

