package ru.mirea.task20;

import java.io.Serializable;

// подходит: наследует Animal и реализует Serializable
public class Cat extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cat(String name) {
        super(name);
    }
}