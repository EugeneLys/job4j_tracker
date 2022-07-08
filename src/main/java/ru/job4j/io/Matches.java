package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            if (count >= 3) {
                System.out.println(player + ", введите число от 1 до 3:");
            } else {
                System.out.println(player + ", введите число от 1 до " + count + ":");
            }
            int matches = Integer.parseInt(input.nextLine());
            if (0 < matches && matches < 4 && matches <= count) {
                turn = !turn;
                count = count - matches;
                System.out.println("Ход сделан. На столе осталось " + count + " спичек.");
            } else {
                System.out.println("Вы ввели неверное число. Повторите ход");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
