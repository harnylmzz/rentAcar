package com.tobeto.rentAcar.controller;

import com.tobeto.rentAcar.entities.Car;
import com.tobeto.rentAcar.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cars")
@RestController
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/getall")
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("/getById")
    public Car getById(int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    @PostMapping("/add")
    public void add(@RequestBody Car car) {
        carRepository.save(car);
    }


    @PutMapping("/update")
    public void update(@RequestBody Car car) {
        Car car1 = carRepository.findById(car.getId())
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + car.getId()));

        car.setId(car.getId());
        car.setColour(car.getColour());
        car.setFuelType(car.getFuelType());
        car.setMileage(car.getMileage());
        car.setName(car.getName());
        car.setDailyPrice(car.getDailyPrice());
        car.setModelYear(car.getModelYear());
        car.setPlate(car.getPlate());
        car.setRateOfEngine(car.getRateOfEngine());
        car.setManufacturingYear(car.getManufacturingYear());

        carRepository.save(car);

    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
