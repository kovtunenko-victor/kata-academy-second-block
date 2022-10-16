package ru.kata.academy.kovtunenko.second.block.model;

public class Car {
    private Long id;
    private String model;
    private String serial;

    public Car(Long id, String model, String serial) {
        this.id = id;
        this.model = model;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
