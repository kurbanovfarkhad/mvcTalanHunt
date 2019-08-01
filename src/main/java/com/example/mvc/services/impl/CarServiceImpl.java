package com.example.mvc.services.impl;

import com.example.mvc.domain.Car;
import com.example.mvc.repositories.CarRepo;
import com.example.mvc.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;
    @Autowired
    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public List<Car> getAll() {
        return carRepo.findAll();
    }

    @Override
    public Car getOne(Long id) {
        return carRepo.finByI(id);
    }

    @Override
    public void delete(Car car) {
        carRepo.delete(car);
    }

    @Override
    public Car update(Car car,Long id) {
        Car carDB = this.getOne(id);
        BeanUtils.copyProperties(car, carDB,"id");

        return carRepo.save(carDB);
    }

    @Override
    public Car addCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public List<Car> findByDescription(String description) {
        return carRepo.findAllByDescription(description);
    }
}
