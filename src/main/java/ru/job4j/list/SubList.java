package ru.job4j.list;

import java.util.Collections;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        if (list.indexOf(el) != list.lastIndexOf(el)) {
            return list.subList(list.indexOf(el), list.lastIndexOf(el));
        }
        return Collections.emptyList();
    }
}