package ru.job4j.early;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.ConsoleOutput;
import ru.job4j.tracker.Output;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenNull() {
        Output output = new ConsoleOutput();
        String password = null;
        String result = PasswordValidator.validate(password);
        Assert.assertEquals(result, output.toString());
    }

    @Test
    public void whenNoDigit() {
        String elements = "Ab_";
        String result = PasswordValidator.validate(elements);
        Assert.assertEquals(result, "");
    }

    @Test
    public void whenNoLetter() {
        char[] elements = new char[] {'1','2','_'};
        boolean result = PasswordValidator.checkLetter(elements);
        Assert.assertFalse(result);
    }

    @Test
    public void whenNoUpperCase() {
        char[] elements = new char[] {'a','b','c'};
        boolean result = PasswordValidator.checkUpperCase(elements);
        Assert.assertFalse(result);
    }

    @Test
    public void whenNoLowerCase() {
        char[] elements = new char[] {'A','B','3'};
        boolean result = PasswordValidator.checkLowerCase(elements);
        Assert.assertFalse(result);
    }

    @Test
    public void whenNoSpecial() {
        char[] elements = new char[] {'_','*','/'};
        boolean result = PasswordValidator.checkLetterOrDigit(elements);
        Assert.assertFalse(result);
    }

    @Test
    public void whenObvious() {
        char[] elements = new char[] {'U','S','E','R'};
        boolean result = PasswordValidator.checkObvious(elements);
        Assert.assertTrue(result);
    }
}