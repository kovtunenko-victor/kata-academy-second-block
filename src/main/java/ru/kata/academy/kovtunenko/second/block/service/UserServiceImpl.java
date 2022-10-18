package ru.kata.academy.kovtunenko.second.block.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(User.getEmptyUser());
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(getUserById(id));
    }
}
