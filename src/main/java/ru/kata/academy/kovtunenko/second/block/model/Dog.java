package ru.kata.academy.kovtunenko.second.block.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Component("Dog")
@Primary
public class Dog extends Animal {

    @Override
    public String toString() {
        return "Im a Dog";
    }
}
