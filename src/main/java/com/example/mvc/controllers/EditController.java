//package com.example.mvc.controllers;
//
//import com.example.mvc.domain.Car;
//import com.example.mvc.services.CarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("car/edit")
//public class EditController {
//    private final CarService carService;
//    @Autowired
//    public EditController(CarService carService) {
//        this.carService = carService;
//    }
//
//    @PostMapping
//    public String edit(Car car){
//        carService.update(car);
//        return "redirect:/";
//    }
//}
