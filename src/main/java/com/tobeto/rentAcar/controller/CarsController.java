package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.CarService;
import com.tobeto.rentAcar.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.dtos.responses.car.GetCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cars")
@RestController
@AllArgsConstructor
public class CarsController {

    private CarService carService;

    @GetMapping("/getall")
    public List<GetCarListResponse> getAll() {
        return this.carService.getAll();
    }

    @GetMapping("/getbyid")
    public GetCarResponse getById(int id) {

        return this.carService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCarRequest addCarRequest) {

        this.carService.add(addCarRequest);
    }


    @PutMapping("/update")
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteCarRequest deleteCarRequest) {
        this.carService.delete(deleteCarRequest);
    }

    @GetMapping("/findbyname")
    public List<GetCarListResponse> findByName(String name) {
        return this.carService.findByName(name);
    }

    @GetMapping("/findbymodelyear")
    public List<GetCarListResponse> findByModelYear(int modelYear) {
        return this.carService.findByModelYear(modelYear);
    }

    @GetMapping("/findbynamecontaining")
    public List<GetCarListResponse> findByNameContaining(String name) {
        return this.carService.findByNameContaining(name);
    }

    @GetMapping("/searchname")
    public List<GetCarListResponse> searchName(String name) {
        return this.carService.searchName(name);
    }

    @GetMapping("/searchnamecontaining")
    public List<GetCarListResponse> searchNameContaining(String name) {
        return this.carService.searchNameContaining(name);
    }
}