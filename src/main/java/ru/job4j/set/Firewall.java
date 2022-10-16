package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String del = " ";
        String[] check = s.split(del);
        for (String checked : check) {
            if (words.contains(checked)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}