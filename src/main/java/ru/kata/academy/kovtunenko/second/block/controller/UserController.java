package ru.kata.academy.kovtunenko.second.block.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.academy.kovtunenko.second.block.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.3.14 version by oct'22 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/user")
    public String printUser(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add(service.getUserById(1L).toString());
        model.addAttribute("messages", messages);

        return "index";
    }
}
