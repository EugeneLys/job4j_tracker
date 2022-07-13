package ru.job4j.tracker;

public class StubInput implements Input {

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askUnt(String question) {
        return 0;
    }
}
