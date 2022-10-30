package ru.job4j.collection;

import java.util.*;

public class Parking {
    public static void main(String[] args) {
        Queue<Car> cars = new LinkedList<>();
        cars.add(new Car("Ford1"));
        cars.add(new Car("Ford2"));
        cars.add(new Car("Ford3"));
        cars.add(new Car("Ford4"));
        cars.offer(new Car("Ford5"));
        for (Car car : cars) {
            System.out.println(car.name);
        }
        cars.remove();
        for (Car car : cars) {
            System.out.println(car.name);
        }
    }

    static class Car {
        private String name;

        public Car(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }
    }
}