package ru.kata.academy.kovtunenko.second.block.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.academy.kovtunenko.second.block.model.Car;
import ru.kata.academy.kovtunenko.second.block.model.User;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = Logger.getLogger(CarDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        try {
            sessionFactory.getCurrentSession().save(car);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, "Exception when save car", ex);
        }
    }

    @Override
    public List<Car> listCar() {
        try {
            TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car", Car.class);
            return query.getResultList();
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, "Exception when get car list", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public User getUserByCar(Car car) {
        try {
            TypedQuery<User> query = sessionFactory.getCurrentSession()
                    .createQuery("SELECT u FROM Car c JOIN c.user u WHERE c.model = :model AND c.series = :series", User.class)
                    .setParameter("model", car.getModel())
                    .setParameter("series", car.getSeries());
            return query.getSingleResult();
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, "Exception when get user by car", ex);
            return User.getEmptyUser();
        }
    }
}
