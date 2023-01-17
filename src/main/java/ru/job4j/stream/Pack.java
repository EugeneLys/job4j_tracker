package ru.job4j.stream;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pack {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
