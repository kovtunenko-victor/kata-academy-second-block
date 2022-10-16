package ru.kata.academy.kovtunenko.second.block.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.academy.kovtunenko.second.block.dao.CarDao;
import ru.kata.academy.kovtunenko.second.block.model.Car;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;
    @Override
    public List<Car> getCars(Long count) {
        return carDao.getCars(count);
    }
}
