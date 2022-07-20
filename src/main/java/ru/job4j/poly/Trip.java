package ru.job4j.poly;

public class Trip {
    public static void main(String[] args) {
        Vehicle schoolbus = new Bus();
        Vehicle tourist = new Bus();
        Vehicle fighter = new Plane();
        Vehicle airplane = new Plane();
        Vehicle metro = new Train();
        Vehicle sapsan = new Train();

        Vehicle[] vehicles = new Vehicle[]{schoolbus, tourist, fighter, airplane,
                metro, sapsan};
        for (Vehicle v : vehicles) {
            System.out.println("Перед нами транспортное средство " + v.toString() + ":");
            v.move();
            v.refuel();
        }
    }
}
