package ru.job4j.comparator;

public class CompareMethod {

    public static int ascendingCompare(int first, int second) {
        int rsl;
        if (first == second) {
            return 0;
        }
        rsl = first > second ? 1 : -1;
        return rsl;
    }

    public static int descendingCompare(int first, int second) {
        int rsl;
        if (first == second) {
            return 0;
        }
        rsl = second > first ? 1 : -1;
        return rsl;
    }
}
