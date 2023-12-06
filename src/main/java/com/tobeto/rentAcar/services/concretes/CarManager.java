package com.tobeto.rentAcar.services.concretes;

import com.tobeto.rentAcar.entities.Car;
import com.tobeto.rentAcar.repository.CarRepository;
import com.tobeto.rentAcar.services.abstracts.CarService;
import com.tobeto.rentAcar.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;

    @Override
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

    @Override
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

    @Override
    public void add(AddCarRequest addCarRequest) {
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

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

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

    @Override
    public void delete(DeleteCarRequest deleteCarRequest) {
        carRepository.deleteById(deleteCarRequest.getId());

    }

    @Override
    public List<GetCarListResponse> findByName(String name) {

        List<Car> cars = carRepository.findByName(name);
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            responseList.add(new GetCarListResponse(car.getId(), car.getModelYear(), car.getName(),
                    car.getDailyPrice(), car.getPlate(), car.getFuelType()));
        }
        return responseList;
    }

    @Override
    public List<GetCarListResponse> findByModelYear(int modelYear) {

        List<Car> cars = carRepository.findByModelYear(modelYear);
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            responseList.add(new GetCarListResponse(car.getId(), car.getModelYear(), car.getName(),
                    car.getDailyPrice(), car.getPlate(), car.getFuelType()));
        }
        return responseList;
    }

    @Override
    public List<GetCarListResponse> findByNameContaining(String name) {

        List<Car> cars = carRepository.findByNameContaining(name);
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            responseList.add(new GetCarListResponse(car.getId(), car.getModelYear(), car.getName(),
                    car.getDailyPrice(), car.getPlate(), car.getFuelType()));
        }
        return responseList;
    }

    @Override
    public List<GetCarListResponse> searchName(String name) {

        List<Car> cars = carRepository.searchName(name);
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            responseList.add(new GetCarListResponse(car.getId(), car.getModelYear(), car.getName(),
                    car.getDailyPrice(), car.getPlate(), car.getFuelType()));
        }
        return responseList;
    }

    @Override
    public List<GetCarListResponse> searchNameContaining(String name) {

        List<Car> cars = carRepository.searchNameContaining(name);
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            responseList.add(new GetCarListResponse(car.getId(), car.getModelYear(), car.getName(),
                    car.getDailyPrice(), car.getPlate(), car.getFuelType()));
        }
        return responseList;
    }


}
