package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по небу.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется керосином.");
    }
}
