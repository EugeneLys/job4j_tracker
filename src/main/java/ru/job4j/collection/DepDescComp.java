package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int count = 0;
        String[] leftSplit = left.split("/");
        String[] rightSplit = right.split("/");
        int result = rightSplit[0].compareTo(leftSplit[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}