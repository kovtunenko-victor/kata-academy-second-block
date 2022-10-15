package ru.kata.academy.kovtunenko.second.block.dao;

import ru.kata.academy.kovtunenko.second.block.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, "Exception when save user", ex);
        }
    }

    @Override
    public List<User> listUsers() {
        try {
            TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
            return query.getResultList();
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, "Exception when get users list", ex);
            return Collections.emptyList();
        }
    }
}
