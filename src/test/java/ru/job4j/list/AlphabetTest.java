package ru.job4j.list;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AlphabetTest {
    @Test
    public void reformat() {
        String rsl = Alphabet.reformat("javascript");
        String expected = "aacijprstv";
        Assertions.assertEquals(rsl, expected);
    }

    @Test
    public void reformat1() {
        String rsl = Alphabet.reformat("websecurityconfigureradapter");
        String expected = "aabccdeeeefgiinoprrrrsttuuwy";
        Assertions.assertEquals(rsl, expected);
    }
}