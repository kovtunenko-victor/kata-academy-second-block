package ru.kata.academy.kovtunenko.second.block.model;

import org.springframework.stereotype.Component;
import ru.kata.academy.kovtunenko.second.block.model.Animal;

@Component
public class Cat extends Animal {
    @Override
    public String toString() {
        return "Im a Cat";
    }
}