package ru.job4j.oop;

import java.sql.SQLOutput;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Nick of this cat: " + this.name);
        System.out.println("There are this cat's food: " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}