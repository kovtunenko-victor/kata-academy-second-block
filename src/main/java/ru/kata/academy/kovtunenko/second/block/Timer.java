package ru.kata.academy.kovtunenko.second.block;

public class Timer {
    private Long nanoTime = System.nanoTime();

    public Long getTime() {
        return nanoTime;
    }
}
