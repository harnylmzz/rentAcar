package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {


    GetBrandResponse getById(int id);

    List<GetBrandListResponse> getAll();

    void add(AddBrandRequest addBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(DeleteBrandRequest deleteBrandRequest);

    List<GetBrandListResponse> findByName(String name);

    List<GetBrandListResponse> findByNameContaining(String name);

    List<GetBrandListResponse> findByNameStartingWith(String name);

    List<GetBrandListResponse> findByNameEndingWith(String name);

    List<GetBrandListResponse> searchName(String name);

    List<GetBrandListResponse> searchNameContaining(String name);

}

