package ru.kata.academy.kovtunenko.second.block.dao;

import ru.kata.academy.kovtunenko.second.block.model.Car;
import ru.kata.academy.kovtunenko.second.block.model.User;

import java.util.List;

public interface CarDao {
    void add(Car car);
    List<Car> listCar();
    User getUserByCar(Car car);
}
