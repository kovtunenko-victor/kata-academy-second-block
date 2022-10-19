package ru.kata.academy.kovtunenko.second.block.repository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.academy.kovtunenko.second.block.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryNoJpa {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryNoJpa.class);
    @Autowired
    EntityManager em;

    public List<User> findAll() {
        try {
            return em.createQuery("FROM User", User.class).getResultList();
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.error("Exception when get all user", ex);
            return Collections.emptyList();
        }
    }

    public Optional<User> findById(Long id) {
        try {
            return Optional.of(em.find(User.class, id));
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException | NullPointerException ex) {
            LOGGER.error("Exception when get user by id", ex);
            return Optional.of(User.getEmptyUser());
        }
    }

    public void save(User user) {
        try {
            em.persist(user);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.error("Exception when save user", ex);
        }
    }

    public void update(User user) {
        try {
            em.merge(user);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.error("Exception when update user", ex);
        }
    }


    public void delete(User user) {
        try {
            em.remove(user);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException ex) {
            LOGGER.error("Exception when delete user", ex);
        }
    }
}
