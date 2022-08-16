package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Please enter the password.");
        }
        char[] symbols = password.toCharArray();
        if (symbols.length < 8 || symbols.length > 32) {
            throw new IllegalArgumentException("The password length should be from 8 to 32 symbols.");
        }
        boolean check;
        for (int index = 0; index < symbols.length; index++) {
            if (Character.isDigit(symbols[index]) ) {
               check = true;
            }
            if (!Character.isDigit(symbols[index])) {
                check = true;
            }
            if (Character.isLetter(symbols[index])) {

            }
            if (Character.isUpperCase(symbols[index])){

            }
            if (Character.isLowerCase(symbols[index]))
        }

        for (char sym : symbols) {
            Character.toUpperCase(sym);
            }
        if (symbols.equals("Q,W,E,R,T,Y") || symbols.equals("1,2,3,4,5") || symbols.equals("P,A,S,S,W,O,R,D")
                || symbols.equals("A,D,M,I,N") || symbols.equals("U,S,E,R")) {
            throw new IllegalArgumentException("The password is too obvious, choose another one.");
        }


        return "password is OK";
    }
}
