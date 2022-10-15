package ru.kata.academy.kovtunenko.second.block.service;

import ru.kata.academy.kovtunenko.second.block.model.Car;
import ru.kata.academy.kovtunenko.second.block.model.User;

import java.util.List;

public interface CarService {
    void add(Car user);

    List<Car> listCars();

    User getUserByCar(Car car);
}
