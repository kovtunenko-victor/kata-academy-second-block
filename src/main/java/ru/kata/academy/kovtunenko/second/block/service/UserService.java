package ru.kata.academy.kovtunenko.second.block.service;

import org.springframework.stereotype.Service;
import ru.kata.academy.kovtunenko.second.block.model.User;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User getUserById(Long id);
    void save(User user);
    void update(User user);
    void deleteById(Long id);
}
