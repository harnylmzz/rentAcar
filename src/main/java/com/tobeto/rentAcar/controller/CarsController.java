package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.dtos.responses.car.GetCarResponse;
import com.tobeto.rentAcar.entities.Car;
import com.tobeto.rentAcar.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/cars")
@RestController
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/getall")
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            GetCarListResponse response = new GetCarListResponse();

            response.setId(car.getId());
            response.setModelYear(car.getModelYear());
            response.setName(car.getName());
            response.setDailyPrice(car.getDailyPrice());
            response.setPlate(car.getPlate());
            response.setFuelType(car.getFuelType());

            responseList.add(response);
        }

        return responseList;
    }

    @GetMapping("/getbyid")
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));

        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setModelYear(car.getModelYear());
        getCarResponse.setName(car.getName());
        getCarResponse.setDailyPrice(car.getDailyPrice());
        getCarResponse.setPlate(car.getPlate());
        getCarResponse.setFuelType(car.getFuelType());

        return getCarResponse;
    }

    @PostMapping("/add")
    public void add(@RequestBody AddCarRequest addCarRequest) {

        Car car = new Car();

        car.setModelYear(addCarRequest.getModelYear());
        car.setName(addCarRequest.getName());
        car.setDailyPrice(addCarRequest.getDailyPrice());
        car.setPlate(addCarRequest.getPlate());
        car.setFuelType(addCarRequest.getFuelType());
        car.setColour(addCarRequest.getColour());
        car.setManufacturingYear(addCarRequest.getManufacturingYear());
        car.setMileage(addCarRequest.getMileage());
        car.setRateOfEngine(addCarRequest.getRateOfEngine());

        carRepository.save(car);
    }


    @PutMapping("/update")
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        Car car = carRepository.findById(updateCarRequest.getId())
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + updateCarRequest.getId()));

        car.setId(updateCarRequest.getId());
        car.setModelYear(updateCarRequest.getModelYear());
        car.setName(updateCarRequest.getName());
        car.setDailyPrice(updateCarRequest.getDailyPrice());
        car.setPlate(updateCarRequest.getPlate());
        car.setColour(updateCarRequest.getColour());
        car.setFuelType(updateCarRequest.getFuelType());
        car.setManufacturingYear(updateCarRequest.getManufacturingYear());
        car.setMileage(updateCarRequest.getMileage());
        car.setRateOfEngine(updateCarRequest.getRateOfEngine());

        carRepository.save(car);

    }

    @DeleteMapping("/delete")
    public DeleteCarRequest delete(int id) {
        carRepository.deleteById(id);

        return new DeleteCarRequest(id);
    }
}