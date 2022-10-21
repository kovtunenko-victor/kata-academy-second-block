package ru.kata.academy.kovtunenko.second.block.repository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionException;
import ru.kata.academy.kovtunenko.second.block.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
    @PersistenceContext
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
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException | TransactionException ex) {
            LOGGER.error("Exception when save user", ex);
        }
    }

    public void update(User user) {
        try {
            em.merge(user);
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException | TransactionException ex) {
            LOGGER.error("Exception when update user", ex);
        }
    }

    public void delete(User user) {
        try {
            if(user.getClass().equals(User.class)) {
                em.remove(user);
            } else {
                throw new IllegalArgumentException("The user variable is not an instance of the User class");
            }
        } catch (IllegalStateException | PersistenceException | IllegalArgumentException | TransactionException ex) {
            LOGGER.error("Exception when delete user", ex);
        }
    }
}
