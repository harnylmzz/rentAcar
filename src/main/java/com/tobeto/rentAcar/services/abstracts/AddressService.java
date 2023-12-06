package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.dtos.responses.address.GetAddressResponse;

import java.util.List;

public interface AddressService {

    List<GetAddressListResponse> getAll();

    GetAddressResponse getById(int id);

    void add(AddAddressRequest addAddressRequest);

    void update(UpdateAddressRequest updateAddressRequest);

    void delete(DeleteAddressRequest deleteAddressRequest);

    List<GetAddressListResponse> findByCountry(String name);

    List<GetAddressListResponse> findByCity(String name);

    List<GetAddressListResponse> searchCountry(String name);

    List<GetAddressListResponse> searchCity(String name);
}
