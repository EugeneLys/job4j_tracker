package ru.job4j.early;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    public void whenCorrect() {
        Assertions.assertEquals(PasswordValidator.validate("A1b_5678"), "Your password is OK.");
    }

    @Test
    public void whenNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate(null));
        Assertions.assertEquals("Please enter the password.", exception.getMessage());
    }

    @Test
    public void whenShort() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("Abc1_"));
        Assertions.assertEquals("The password length should be from 8 to 32 symbols.",
                exception.getMessage());
    }

    @Test
    public void whenNoDigit() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("Abcdefgh_"));
        Assertions.assertEquals("You should use at least one digit in the password.",
                exception.getMessage());
    }

    @Test
    public void whenNoLetter() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("123456_8"));
        Assertions.assertEquals("You should use at least one letter in the password.",
                exception.getMessage());
    }

    @Test
    public void whenNoUpperCase() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("1_cdefgh"));
        Assertions.assertEquals("You should use at least one upper case symbol in the password.",
                exception.getMessage());
    }

    @Test
    public void whenNoLowerCase() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("1_CDEFGH"));
        Assertions.assertEquals("You should use at least one lower case symbol in the password.",
                exception.getMessage());
    }

    @Test
    public void whenNoSpecial() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("1bCDEFGH"));
        Assertions.assertEquals("You should use at least one special symbol (not digit or letter) "
                + "in the password.", exception.getMessage());
    }

    @Test
    public void whenObvious() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate("Abc_123_qwERTy"));
        Assertions.assertEquals("Your password is too obvious, choose another one.",
                exception.getMessage());
    }
}