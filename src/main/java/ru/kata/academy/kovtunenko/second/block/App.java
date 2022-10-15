package ru.kata.academy.kovtunenko.second.block;

import ru.kata.academy.kovtunenko.second.block.config.AppConfig;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        userService.listUsers().forEach(System.out::println);

        context.close();
    }
}
