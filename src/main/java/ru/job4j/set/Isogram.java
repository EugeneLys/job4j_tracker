package ru.job4j.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        String[] checked = s.split("");
        Set<String> checker = new HashSet<>();
        Collections.addAll(checker, checked);
        return checked.length == checker.size();
    }
}