package ru.kata.academy.kovtunenko.second.block.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
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

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", service.getById(id));
        model.addAttribute("method", "PATCH");
        return "edit";
    }

    @GetMapping("/users/create")
    public String editUser(ModelMap model) {
        model.addAttribute("user", User.getEmptyUser());
        model.addAttribute("method", "POST");
        return "edit";
    }

    @PostMapping("/users/update")
    public String createUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/users";
    }

    @PatchMapping("/users/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        LOGGER.info(user.toString());
        LOGGER.info(id == null ? "null" : id.toString());
        service.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id", required = true) Long id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}
