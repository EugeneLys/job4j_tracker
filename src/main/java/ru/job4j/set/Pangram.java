package ru.job4j.set;

import java.util.*;

public class Pangram {
    public static boolean checkString(String s) {
        String[] verbs = s.split("");
        Set<String> checker = new HashSet<>();
        List<String> splitted = new ArrayList<>();
        for (String str : verbs) {
            if (!str.equals(" ")) {
                splitted.add(str);
            }
        }
        checker.addAll(splitted);
        System.out.println(checker);
        if (checker.size() == 26) {
            return true;
        }
        return false;
    }
}
