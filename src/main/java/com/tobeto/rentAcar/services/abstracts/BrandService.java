package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {


    GetBrandResponse getById(int id);

    List<GetBrandListResponse> getAll();

    void add(AddBrandRequest addBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(DeleteBrandRequest deleteBrandRequest);

}

