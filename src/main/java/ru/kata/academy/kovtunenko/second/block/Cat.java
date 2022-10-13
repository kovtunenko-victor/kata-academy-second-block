package ru.kata.academy.kovtunenko.second.block;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal {
    @Override
    public String toString() {
        return "Im a Cat";
    }
}