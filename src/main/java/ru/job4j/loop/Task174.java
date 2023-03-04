package ru.job4j.loop;

public class Task174 {
    public static void isPalindrome(int number) {
        int exqlusive = number;
        int compared = 0;
        while (number / 10 > compared) {
            compared = compared * 10 + number % 10;
            number = number / 10;
        }
        if (exqlusive < 10 || number == compared
                || (compared != 0 && (number == compared * 10 + number % 10))) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}