package ru.job4j.early;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.ConsoleOutput;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.StubOutput;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenCorrect() {
        String elements = "A1b_5678";
        String result = PasswordValidator.validate(elements);
        Assertions.assertEquals(result, "Your password is OK.");
    }

    @Test
    public void whenNull() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = null;
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("Please enter the password.", thrown.getMessage());
    }

    @Test
    public void whenShort() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "Abc1_";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("The password length should be from 8 to 32 symbols.", thrown.getMessage());
    }

    @Test
    public void whenNoDigit() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "Abcdefgh_";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("You should use at least one digit in the password.", thrown.getMessage());
    }

    @Test
    public void whenNoLetter() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "123456_8";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("You should use at least one letter in the password.", thrown.getMessage());
    }

    @Test
    public void whenNoUpperCase() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "1_cdefgh";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("You should use at least one upper case symbol in the password.", thrown.getMessage());
    }

    @Test
    public void whenNoLowerCase() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "1_CDEFGH";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("You should use at least one lower case symbol in the password.", thrown.getMessage());
    }

    @Test
    public void whenNoSpecial() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "1bCDEFGH";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("You should use at least one special symbol (not digit or letter) in the password.", thrown.getMessage());
    }

    @Test
    public void whenObvious() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String elements = "QWeRtY-12345";
            String result = PasswordValidator.validate(elements);
        });
        Assertions.assertEquals("Your password is too obvious, choose another one.", thrown.getMessage());
    }
}