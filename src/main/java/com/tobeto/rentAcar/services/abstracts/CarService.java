package com.tobeto.rentAcar.services.abstracts;

import com.tobeto.rentAcar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentAcar.services.dtos.requests.car.DeleteCarRequest;
import com.tobeto.rentAcar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentAcar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentAcar.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {

    GetCarResponse getById(int id);

    List<GetCarListResponse> getAll();

    void add(AddCarRequest addCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    void delete(DeleteCarRequest deleteCarRequest);
}
