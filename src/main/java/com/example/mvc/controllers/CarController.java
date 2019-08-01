package com.example.mvc.controllers;

import com.example.mvc.domain.Car;
import com.example.mvc.repositories.CarRepo;
import com.example.mvc.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("car")
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/add")
    public String addPage(){

        return "add";
    }

    @GetMapping("/add/{id}")
    public String addPage(@PathVariable("id") Long id, Model model){
        Car car =carService.getOne(id);
        if (car!=null){
            model.addAttribute("car", car);
            model.addAttribute("update",true);
        }else
            model.addAttribute("update",false);
        return "add";
    }

    @PostMapping("add/{id}")
    public String addApplication(Car car, @PathVariable("id") Long id){
        if (id!=null){
            carService.update(car,id);
        }else{
            carService.addCar(car);
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Car car){
        carService.delete(car);
        return "redirect:/";
    }
}
