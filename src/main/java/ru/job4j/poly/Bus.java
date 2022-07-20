package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void drive() {
        System.out.println("The bus is moving.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("There are " + passengers + " passengers on board.");
    }

    @Override
    public double refuel(double fuel) {
        double price = 50.0;
        return fuel * price;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по городским улицам.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется бензином.");
    }
}
