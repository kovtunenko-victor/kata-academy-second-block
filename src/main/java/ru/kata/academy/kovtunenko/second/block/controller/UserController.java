package ru.kata.academy.kovtunenko.second.block.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kata.academy.kovtunenko.second.block.model.User;
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

    @GetMapping(value = "/users")
    public String printUser(ModelMap model) {
        model.addAttribute("users", service.get());
        return "users";
    }

    @GetMapping(value = "/users/edit/{id}")
    public String editUser(@PathVariable(value = "id", required = false) int id, ModelMap model) {
        model.addAttribute("id", id);
        return "edit";
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id", required = true) int id) {
        //model.addAttribute("users", service.get());
        return "edit";
    }
}
