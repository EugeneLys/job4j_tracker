package ru.job4j.map;

import java.util.*;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> map = new TreeMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                List<Integer> list = map.get(array[i]);
                if (map.get(array[i]) == null) {
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(array[i], list);
            }
        }
        return map;
    }
}