package ru.kata.academy.kovtunenko.second.block.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.academy.kovtunenko.second.block.dao.CarDao;
import ru.kata.academy.kovtunenko.second.block.model.Car;
import ru.kata.academy.kovtunenko.second.block.model.User;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> listCars() {
        return carDao.listCar();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByCar(Car car) {
        return carDao.getUserByCar(car);
    }
}
