package com.example.mvc.services;

import com.example.mvc.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> getAll();
    Car getOne(Long id);
    void delete(Car car);
    Car update(Car car,Long id);
    Car addCar(Car car);
    List<Car> findByDescription(String description);
}
