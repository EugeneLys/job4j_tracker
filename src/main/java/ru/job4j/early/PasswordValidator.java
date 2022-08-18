package ru.job4j.early;

import java.util.Arrays;

public class PasswordValidator {

    public static String validate(String password) {
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
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkLetter(char[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkUpperCase(char[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (Character.isUpperCase(array[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkLowerCase(char[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLowerCase(array[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkLetterOrDigit(char[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (!Character.isLetterOrDigit(array[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkObvious(char[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.toUpperCase(array[i]);
        }
        if (Arrays.equals(array, new char[]{'Q', 'W', 'E', 'R', 'T', 'Y'})
            || Arrays.equals(array, new char[]{'1', '2', '3', '4', '5'})
            || Arrays.equals(array, new char[]{'P', 'A', 'S', 'S', 'W', 'O', 'R', 'D'})
            || Arrays.equals(array, new char[]{'A', 'D', 'M', 'I', 'N'})
            || Arrays.equals(array, new char[]{'U', 'S', 'E', 'R'})) {
            check = true;
        }
        return check;
    }
}
