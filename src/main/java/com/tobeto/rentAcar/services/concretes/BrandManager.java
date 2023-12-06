package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.repository.BrandRepository;
import com.tobeto.rentAcar.services.abstracts.BrandService;
import com.tobeto.rentAcar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandResponse;
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

    @Override
    public List<GetBrandListResponse> findByName(String name) {

        List<Brand> brands = brandRepository.findByName(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));

        }
        return responseList;
    }

    @Override
    public List<GetBrandListResponse> findByNameContaining(String name) {

        List<Brand> brands = brandRepository.findByNameContaining(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));
        }
        return responseList;
    }

    @Override
    public List<GetBrandListResponse> findByNameStartingWith(String name) {

        List<Brand> brands = brandRepository.findByNameStartingWith(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands
        ) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));

        }
        return responseList;
    }

    @Override
    public List<GetBrandListResponse> findByNameEndingWith(String name) {

        List<Brand> brands = brandRepository.findByNameEndingWith(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));
        }
        return responseList;
    }

    @Override
    public List<GetBrandListResponse> searchName(String name) {

        List<Brand> brands = brandRepository.searchName(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));
        }
        return responseList;
    }

    @Override
    public List<GetBrandListResponse> searchNameContaining(String name) {

        List<Brand> brands = brandRepository.searchNameContaining(name);
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            responseList.add(new GetBrandListResponse(brand.getId(), brand.getName()));
        }
        return responseList;
    }

}
