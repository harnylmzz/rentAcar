package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.services.abstracts.CarService;
import com.tobeto.rentAcar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.services.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.services.dtos.responses.car.GetCarResponse;
import com.tobeto.rentAcar.entities.Car;
import com.tobeto.rentAcar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public void add(@RequestBody AddCarRequest addCarRequest) {

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
}