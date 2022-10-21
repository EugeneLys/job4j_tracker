package ru.job4j.tracker;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemComparatorTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
        new Item(2, "bbb"),
        new Item(3, "ccc"),
        new Item(1, "aaa")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
        new Item(1, "aaa"),
        new Item(2, "bbb"),
        new Item(3, "ccc")
        );
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
        new Item(111, "A111"),
        new Item(222, "B222"),
        new Item(333, "C333")
                );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
        new Item(333, "C333"),
        new Item(222, "B222"),
        new Item(111, "A111")
        );
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }
}
