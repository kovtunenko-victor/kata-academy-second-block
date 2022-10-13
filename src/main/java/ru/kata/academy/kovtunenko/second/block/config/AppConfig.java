package ru.kata.academy.kovtunenko.second.block.config;

import ru.kata.academy.kovtunenko.second.block.models.Egg6;
import ru.kata.academy.kovtunenko.second.block.models.Island2;
import ru.kata.academy.kovtunenko.second.block.models.Wood3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.kata.academy.kovtunenko.second.block")
public class AppConfig {

    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }

    @Bean
    public static Egg6 getEgg() {
        return new Egg6();
    }
}
