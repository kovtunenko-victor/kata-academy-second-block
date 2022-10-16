package ru.kata.academy.kovtunenko.second.block.dao;

import ru.kata.academy.kovtunenko.second.block.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars(Long count);
}
