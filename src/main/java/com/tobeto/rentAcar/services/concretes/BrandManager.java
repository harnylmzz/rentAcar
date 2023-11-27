package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.repository.BrandRepository;
import com.tobeto.rentAcar.services.abstracts.BrandService;
import com.tobeto.rentAcar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<GetBrandListResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            GetBrandListResponse response = new GetBrandListResponse();

            response.setId(brand.getId());
            response.setName(brand.getName());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));

        GetBrandResponse getBrandResponse = new GetBrandResponse();
        getBrandResponse.setName(brand.getName());

        return getBrandResponse;
    }

    @Override
    public void add(AddBrandRequest addBrandRequest) {

        Brand brand = new Brand();

        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = brandRepository.findById(updateBrandRequest.getId())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + updateBrandRequest.getId()));

        brand.setId(updateBrandRequest.getId());
        brand.setName(updateBrandRequest.getName());

        brandRepository.save(brand);

    }

    @Override
    public void delete(DeleteBrandRequest deleteBrandRequest) {

        brandRepository.deleteById(deleteBrandRequest.getId());

    }

}
