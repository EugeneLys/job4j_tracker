package ru.job4j.early;
import java.util.Arrays;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException("Please enter the password.");
        }
        char[] symbols = password.toCharArray();
        if (symbols.length < 8 || symbols.length > 32) {
            throw new IllegalArgumentException("The password length should be "
                    + "from 8 to 32 symbols.");
        }
        if (!checkDigit(symbols)) {
            throw new IllegalArgumentException("You should use at least one "
                    + "digit in the password.");
        }
        if (!checkLetter(symbols)) {
            throw new IllegalArgumentException("You should use at least one "
                    + "letter in the password.");
        }
        if (!checkUpperCase(symbols)) {
            throw new IllegalArgumentException("You should use at least one "
                    + "upper case symbol in the password.");
        }
        if (!checkLowerCase(symbols)) {
            throw new IllegalArgumentException("You should use at least one "
                    + "lower case symbol in the password.");
        }
        if (!checkLetterOrDigit(symbols)) {
            throw new IllegalArgumentException("You should use at least one "
                    + "special symbol (not digit or letter) in the password.");
        }
        if (checkObvious(password)) {
            throw new IllegalArgumentException("Your password is too obvious, choose another one.");
        }
        return "Your password is OK.";
    }

    public static boolean checkDigit(char[] array) {
        for (char c : array) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLetter(char[] array) {
        for (char c : array) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUpperCase(char[] array) {
        for (char c : array) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLowerCase(char[] array) {
        for (char c : array) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLetterOrDigit(char[] array) {
        for (char c : array) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkObvious(String password) {
        return password.toUpperCase().contains("QWERTY")
                || password.toUpperCase().contains("USER")
                || password.toUpperCase().contains("ADMIN")
                || password.toUpperCase().contains("PASSWORD")
                || password.toUpperCase().contains("12345");
    }
}
