package ru.job4j.list;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueElementTest {
    @Test
    public void checkListTrue() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        boolean result = UniqueElement.checkList(list, "second");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkListFalse() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("second");
        list.add("fourth");
        boolean result = UniqueElement.checkList(list, "second");
        Assertions.assertFalse(result);
    }

    @Test
    public void checkListNoContainsElement() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        boolean result = UniqueElement.checkList(list, "fourth");
        Assertions.assertFalse(result);
    }
}