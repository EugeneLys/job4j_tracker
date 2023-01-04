package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (key, val) -> map.put(key, val);
        List<String> str = List.of("one", "two", "three", "four",
                "five", "six", "seven");
        int j = 1;
        for (String s : str) {
            biCon.accept(j++, s);
        }

        BiPredicate<Integer, String> biPred = (key, val) -> key % 2 == 0 || val.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            func.apply(s);
            con.accept(s);
        }
    }
}