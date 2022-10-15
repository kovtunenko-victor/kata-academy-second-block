package ru.kata.academy.kovtunenko.second.block;

import ru.kata.academy.kovtunenko.second.block.config.AppConfig;
import ru.kata.academy.kovtunenko.second.block.model.Car;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.service.CarService;
import ru.kata.academy.kovtunenko.second.block.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private static final UserService userService = context.getBean(UserService.class);
    private static final CarService carService = context.getBean(CarService.class);

    public static void main(String[] args) {
        generateUsers();

        userService.listUsers().forEach(System.out::println);

        System.out.println("-------------------------------");

        User user = carService.getUserByCar(new Car("Mercedes", 1112131415));
        System.out.println(user);

        user = carService.getUserByCar(new Car("-", 0));
        System.out.println(user);

        context.close();
    }

    private static void generateUsers() {
        String[] names = new String[]{"Viktor", "Vladimir", "Andrey", "Timur"};
        String[] lastnames = new String[]{"Kovtunenko", "Ovsanikov", "Popov", "Husainov"};
        String[] emails = new String[]{"vk@mail.ru", "vo@mail.ru", "ap@mail.ru", "th@mail.ru"};

        String[] models = new String[]{"Lada", "BMW", "Mercedes", "Kia"};
        Integer[] series = new Integer[]{12345, 678910, 1112131415, 1617181920};

        userService.add(new User("Alexander", "Filin", "af@mail.ru"));

        for(int i = 0; i < 4; i++) {
            User user = new User(names[i], lastnames[i], emails[i]);
            userService.add(user);
            Car car = new Car(models[i], series[i]);
            car.setUser(user);
            carService.add(car);
        }

        userService.add(new User("Alexey", "Loshinin", "al@mail.ru"));
    }
}
