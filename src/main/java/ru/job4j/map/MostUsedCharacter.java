package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        str.toLowerCase();
        char[] array = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (Character el : array
             ) {
            map.computeIfPresent(el);
            map.putIfAbsent(el, );

        }
        char rsl = ' ';
        return rsl;
    }
}