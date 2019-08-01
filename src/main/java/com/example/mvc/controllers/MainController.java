package com.example.mvc.controllers;

import com.example.mvc.domain.Car;
import com.example.mvc.domain.Role;
import com.example.mvc.domain.User;
import com.example.mvc.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final CarService carService;
    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model,Car Car){
        model.addAttribute("isAdmin", user.getAuthorities().contains(Role.ADMIN));
        model.addAttribute("cars",carService.getAll());
        return "index";
    }
    @GetMapping("search/{description}")
    public String search(@PathVariable(value = "description" ) String description,Model model){
        model.addAttribute("cars",carService.findByDescription(description));
        return "redirect:/";
    }

}
