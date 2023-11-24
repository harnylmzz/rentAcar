package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.repository.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {


    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/getall")
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


    @GetMapping("/getbyid")
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));

        GetBrandResponse getBrandResponse = new GetBrandResponse();
        getBrandResponse.setName(brand.getName());

        return getBrandResponse;
    }

    @PostMapping("/add")
    public void add(@RequestBody AddBrandRequest addBrandRequest) {

        Brand brand = new Brand();

        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);

    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        Brand brand = brandRepository.findById(updateBrandRequest.getId())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + updateBrandRequest.getId()));

        brand.setName(updateBrandRequest.getName());

        brandRepository.save(brand);
    }


    @DeleteMapping("/delete")
    public DeleteBrandRequest delete(int id) {

        brandRepository.deleteById(id);

        return new DeleteBrandRequest(id);
    }

}
