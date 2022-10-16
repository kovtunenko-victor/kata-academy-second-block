package ru.kata.academy.kovtunenko.second.block.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.academy.kovtunenko.second.block.service.CarService;
import java.util.Objects;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public String printCars(@RequestParam(value = "count", required = false) Long count, Model model) {
        model.addAttribute("cars", carService.getCars(Objects.requireNonNullElse(count, 5L)));
        return "car";
    }
}
