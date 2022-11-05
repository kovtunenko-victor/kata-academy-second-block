package ru.kata.academy.kovtunenko.second.block.repository;


import ru.kata.academy.kovtunenko.second.block.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}
