package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is moving.");
    }

    @Override
    public void passangers(int passangers) {
        System.out.println("There are " + passangers + " passengers on board.");
    }

    @Override
    public double refuel(double fuel) {
        double price = 50.0;
        return fuel * price;
    }
}
