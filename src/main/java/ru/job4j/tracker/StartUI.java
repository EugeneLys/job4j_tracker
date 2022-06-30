package ru.job4j.tracker;

import org.w3c.dom.ls.LSOutput;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item first = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String whenFirstCreated = first.getCreated().format(formatter);
        System.out.println("first создан: " + whenFirstCreated);
    }
}
