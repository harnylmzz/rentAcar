package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.entities.Brand;
import com.tobeto.rentAcar.repository.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {


    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @GetMapping("/getall")
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @GetMapping("/getById")
    public Brand getById(int id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    @PostMapping("/add")
    public void add(@RequestBody Brand brand) {
        brandRepository.save(brand);

    }

    @PutMapping("/update")
    public void update(@RequestBody Brand brand) {
        Brand brand1 = brandRepository.findById(brand.getId())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + brand.getId()));

        brand.setId(brand.getId());
        brand.setName(brand.getName());

        brandRepository.save(brand);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {

        brandRepository.deleteById(id);
    }


}
