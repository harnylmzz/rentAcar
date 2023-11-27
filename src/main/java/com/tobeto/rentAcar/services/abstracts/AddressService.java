package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.rentAcar.services.dtos.requests.address.DeleteAddressRequest;
import com.tobeto.rentAcar.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.rentAcar.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.rentAcar.services.dtos.responses.address.GetAddressResponse;

import java.util.List;

public interface AddressService {

    List<GetAddressListResponse> getAll();

    GetAddressResponse getById(int id);

    void add(AddAddressRequest addAddressRequest);

    void update(UpdateAddressRequest updateAddressRequest);

    void delete(DeleteAddressRequest deleteAddressRequest);
}
