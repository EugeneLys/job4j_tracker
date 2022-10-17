package ru.job4j.list;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeomProgressionTest {
    @Test
    public void generateAndSum() {
        int rsl = GeomProgression.generateAndSum(1, 3, 10);
        Assertions.assertEquals(rsl, 29524);
    }

    @Test
    public void generateAndSumIs0() {
        int rsl = GeomProgression.generateAndSum(1, -1, 10);
        Assertions.assertEquals(rsl, 0);
    }
}