package ru.kata.academy.kovtunenko.second.block.service;

import ru.kata.academy.kovtunenko.second.block.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars(Long count);
}
