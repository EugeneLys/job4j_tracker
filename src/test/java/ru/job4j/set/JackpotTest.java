package ru.job4j.set;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JackpotTest {
    @Test
    public void checkYourWinTrue() {
        String[] strings = {"@", "@", "@", "@"};
        boolean win = Jackpot.checkYourWin(strings);
        Assertions.assertTrue(win);
    }

    @Test
    public void checkYourWinFalse() {
        String[] strings = {"&&", "&", "&&&", "&&&&"};
        boolean win = Jackpot.checkYourWin(strings);
        Assertions.assertFalse(win);
    }
}