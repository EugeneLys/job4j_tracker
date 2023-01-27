package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional var = max(data);
        if(var.isPresent()) {
            System.out.println("Max: " + var.get());
        }
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length == 0) {
            return Optional.empty();
        } else {
            Arrays.sort(data);
            return Optional.of(data[data.length - 1]);
        }
    }
}
