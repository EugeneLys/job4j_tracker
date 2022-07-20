package ru.job4j.poly;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " использует электричество.");
    }
}
