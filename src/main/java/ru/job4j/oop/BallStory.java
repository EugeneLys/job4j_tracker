package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare poprygayka = new Hare();
        Wolf grey = new Wolf();
        Fox red = new Fox();
        System.out.println("The Ball meets poprygayka");
        poprygayka.tryEat(kolobok);
        System.out.println("The Ball meets grey");
        grey.tryEat(kolobok);
        System.out.println("The Ball meets red");
        red.tryEat(kolobok);
    }
}
