package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        str = str.replaceAll("\\s+", "");
        String str2 = str.toLowerCase();
        char[] array = str2.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : array) {
            map.computeIfPresent(c,
                    (key, val) -> val + 1);
            map.putIfAbsent(c, 1);
        }
        int x = 1;
        char rsl = ' ';
        for (Character key : map.keySet()) {
            int y = map.get(key);
            if (y > x) {
                rsl = key;
                x = y;
            }
        }
        return rsl;
    }
}