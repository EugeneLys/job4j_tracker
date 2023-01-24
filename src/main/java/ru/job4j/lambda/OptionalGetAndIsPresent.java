package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        if (indexOf(data, el).isPresent()) {
            return indexOf(data, el).get();
        } else {
            return -1;
        }

    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}