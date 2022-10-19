package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PutContainsKey {

    public static Map<Integer, User> addNewElementWithoutCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User next : list) {
            rsl.put(next.id(), next);
        }
        return rsl;
    }

    public static Map<Integer, User> addNewElementWithCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User next : list) {
            if (!rsl.containsKey(next.id)) {
                rsl.put(next.id(), next);
            }
        }
        return rsl;
    }

    public record User(int id, String name) {
    }
}
