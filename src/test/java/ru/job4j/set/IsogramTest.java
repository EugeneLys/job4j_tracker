package ru.job4j.set;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IsogramTest {
    @Test
    public void checkStringTrue() {
        String s = "uncopyrightables";
        boolean b = Isogram.checkString(s);
        Assertions.assertTrue(b);
    }

    @Test
    public void checkStringFalse() {
        String s = "javascript";
        boolean b = Isogram.checkString(s);
        Assertions.assertFalse(b);
    }
}