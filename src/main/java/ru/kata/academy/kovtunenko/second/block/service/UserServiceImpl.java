package ru.kata.academy.kovtunenko.second.block.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> get() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return Optional.ofNullable(userRepository.findById(id)).orElse(User.getEmptyUser());
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, User user) {
        user.setId(id);
        userRepository.update(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(getById(id));
    }
}