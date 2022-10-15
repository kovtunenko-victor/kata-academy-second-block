package ru.kata.academy.kovtunenko.second.block.service;

import ru.kata.academy.kovtunenko.second.block.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}
