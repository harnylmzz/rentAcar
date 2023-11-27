package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.BrandService;
import com.tobeto.rentAcar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @GetMapping("/getall")
    public List<GetBrandListResponse> getAll() {

        return this.brandService.getAll();

    }


    @GetMapping("/getbyid")
    public GetBrandResponse getById(int id) {

        return this.brandService.getById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody AddBrandRequest addBrandRequest) {

        this.brandService.add(addBrandRequest);


    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {

        this.brandService.update(updateBrandRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteBrandRequest deleteBrandRequest) {

        this.brandService.delete(deleteBrandRequest);
    }
}