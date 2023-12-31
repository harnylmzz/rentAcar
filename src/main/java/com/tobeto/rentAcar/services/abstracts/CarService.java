package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {

    GetCarResponse getById(int id);

    List<GetCarListResponse> getAll();

    void add(AddCarRequest addCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    void delete(DeleteCarRequest deleteCarRequest);

    List<GetCarListResponse> findByName(String name);

    List<GetCarListResponse> findByModelYear(int modelYear);

    List<GetCarListResponse> findByNameContaining(String name);

    List<GetCarListResponse> searchName(String name);

    List<GetCarListResponse> searchNameContaining(String name);


}
