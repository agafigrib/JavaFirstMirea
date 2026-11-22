package ru.mirea.task20;

import java.io.Serializable;

// подходит: наследует Animal и реализует Serializable
public class Dog extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    public Dog(String name) {
        super(name);
    }
}
