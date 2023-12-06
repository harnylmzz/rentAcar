package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.BrandService;
import com.tobeto.rentAcar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.DeleteBrandRequest;
import com.tobeto.rentAcar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentAcar.dtos.responses.brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest) {

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

    @GetMapping("/findbyname")
    public List<GetBrandListResponse> findByName(@RequestParam String name) {
        return this.brandService.findByName(name);
    }

    @GetMapping("/findbynamecontaining")
    public List<GetBrandListResponse> findByNameContaining(@RequestParam String name) {
        return this.brandService.findByNameContaining(name);
    }

    @GetMapping("/findbynamestartingwith")
    public List<GetBrandListResponse> findByNameStartingWith(@RequestParam String name) {
        return this.brandService.findByNameStartingWith(name);
    }

    @GetMapping("/findbynameendingwith")
    public List<GetBrandListResponse> findByNameEndingWith(@RequestParam String name) {
        return this.brandService.findByNameEndingWith(name);
    }

    @GetMapping("/searchname")
    public List<GetBrandListResponse> searchName(@RequestParam String name) {
        return this.brandService.searchName(name);
    }

    @GetMapping("/searchnamecontaining")
    public List<GetBrandListResponse> searchNameContaining(@RequestParam String name) {
        return this.brandService.searchNameContaining(name);
    }
}