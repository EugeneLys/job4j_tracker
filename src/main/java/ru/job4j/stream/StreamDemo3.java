package ru.job4j.stream;

import java.util.ArrayList;

public class StreamDemo3 {

    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(4.0);
        myList.add(9.0);
        myList.add(16.0);

        double productOfSum = myList.stream()
                .reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("result: " + productOfSum);
    }
}
