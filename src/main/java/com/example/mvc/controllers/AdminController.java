package com.example.mvc.controllers;

import com.example.mvc.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @GetMapping("index")
    public String admin(Model model){
        model.addAttribute("users",userService.getAll());
        return "admin/index";
    }
}
