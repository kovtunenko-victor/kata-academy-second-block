package ru.kata.academy.kovtunenko.second.block.dao;

import ru.kata.academy.kovtunenko.second.block.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
}

