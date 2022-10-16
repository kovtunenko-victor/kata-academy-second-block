package ru.kata.academy.kovtunenko.second.block.dao;

import org.springframework.stereotype.Repository;
import ru.kata.academy.kovtunenko.second.block.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car>  cars = Arrays.asList(
            new Car(1L, "Mercedes", "123456"),
            new Car(2L, "BMW", "654321"),
            new Car(3L, "Lada", "456789"),
            new Car(4L, "Kia", "987654"),
            new Car(5L, "Renault", "123789"));
    @Override
    public List<Car> getCars(Long count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
