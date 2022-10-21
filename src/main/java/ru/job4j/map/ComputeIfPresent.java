package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer integer : name.keySet()) {
            name.computeIfPresent(integer, (Integer, String) -> String
                    + " " + surname.get(integer));
        }
        return name;
    }
}
