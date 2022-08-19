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
        if (checkObvious(symbols)) {
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

    public static boolean checkObvious(char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.toUpperCase(array[i]);
        }
        char[][] keywords = new char[5][];
        keywords[0] = new char[]{'Q', 'W', 'E', 'R', 'T', 'Y'};
        keywords[1] = new char[]{'1', '2', '3', '4', '5'};
        keywords[2] = new char[]{'P', 'A', 'S', 'S', 'W', 'O', 'R', 'D'};
        keywords[3] = new char[]{'A', 'D', 'M', 'I', 'N'};
        keywords[4] = new char[]{'U', 'S', 'E', 'R'};
        char[] controller = new char[array.length];
        int count = 0;
        for (char[] keyword : keywords) {
            for (int j = 0; j < array.length; j++) {
                while (array[j] == keyword[count]) {
                    controller[count] = array[j];
                    count++;
                    j++;
                    if (Arrays.equals(Arrays.copyOf(controller, count), keyword)) {
                        return true;
                    }
                }
                count = 0;
            }
        }
        return false;
    }
}
