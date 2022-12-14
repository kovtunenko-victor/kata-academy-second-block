package ru.kata.academy.kovtunenko.second.block.service;

import ru.kata.academy.kovtunenko.second.block.model.User;
import java.util.List;

public interface UserService {
    List<User> get();
    User getById(Long id);
    void save(User user);
    void update(Long id, User user);
    void deleteById(Long id);
}
