package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int count = 0;
        String[] leftSplit = left.split("/");
        String[] rightSplit = right.split("/");
        int size = Math.min(leftSplit[count].length(), rightSplit[count].length());
        int countMax = Math.min(leftSplit.length, rightSplit.length) - 1;
        for (int i = 0; i < size; i++) {
            rsl = Character.compare(rightSplit[count].charAt(i), leftSplit[count].charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        while (count < countMax) {
            count++;
            int max = Math.min(leftSplit[count].length(), rightSplit[count].length());
            for (int i = 0; i < max; i++) {
                rsl = Character.compare(leftSplit[count].charAt(i), rightSplit[count].charAt(i));
                if (rsl != 0) {
                    return rsl;
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
