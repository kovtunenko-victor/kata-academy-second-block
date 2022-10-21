package ru.kata.academy.kovtunenko.second.block.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import ru.kata.academy.kovtunenko.second.block.repository.UserRepository;
import ru.kata.academy.kovtunenko.second.block.repository.UserRepositoryImpl;
import ru.kata.academy.kovtunenko.second.block.service.UserService;
import ru.kata.academy.kovtunenko.second.block.service.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public UserService userService () {
        return new UserServiceImpl();
    }

    @Bean
    public UserRepository userRepositoryMock(){
        return mock(UserRepository.class);
    }
}
