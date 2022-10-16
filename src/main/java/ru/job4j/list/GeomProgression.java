package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> geometrical = new ArrayList<>();
        int counter = 0;
        int next = first;
        while (counter < count) {
            geometrical.add(next);
            next = next * denominator;
            counter++;
        }
        Iterator<Integer> iterator = geometrical.iterator();
        int rsl = 0;
        while (iterator.hasNext()) {
            rsl = rsl + iterator.next();
        }
        return rsl;
    }
}