package ru.kata.academy.kovtunenko.second.block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.academy.kovtunenko.second.block.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
