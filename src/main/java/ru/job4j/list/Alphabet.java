package ru.job4j.list;

import java.util.*;

public class Alphabet {
    public static String reformat(String s) {
        String[] temporary = s.split("");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, temporary);
        Comparator comparator = Comparator.naturalOrder();
        list.sort(comparator);
        return String.join("", list);
    }
}
