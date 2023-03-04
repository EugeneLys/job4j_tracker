package ru.job4j.condition;

public class Task49 {
    public static void isPalindrome(int number) {
        var whether = true;
        String guess = Integer.toString(number);
        for (int i = 0; i < guess.length() / 2; i++) {
            if (guess.charAt(i) != guess.charAt(guess.length() - (1 + i))) {
                System.out.println("Нет");
                whether = false;
                break;
            }
        }
        if (whether) {
            System.out.println("Да");
        }
    }
}
