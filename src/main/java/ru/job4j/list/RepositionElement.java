package ru.job4j.list;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
            String change = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        if (index < list.size() && index >= 0) {
            list.set(index, change);
        }
        return list;
    }
}