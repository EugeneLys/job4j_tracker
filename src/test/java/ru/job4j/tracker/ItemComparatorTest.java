package ru.job4j.tracker;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemComparatorTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(0, new Item(2, "bbb"));
        items.add(1, new Item(3, "ccc"));
        items.add(2, new Item(1, "aaa"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(0, new Item(1, "aaa"));
        expected.add(1, new Item(2, "bbb"));
        expected.add(2, new Item(3, "ccc"));
        ArrayList<Integer> itemsID = new ArrayList<>();
        for (Item item : items) {
            itemsID.add(item.getId());
        }
        ArrayList<Integer> expectedID = new ArrayList<>();
        for (Item exp : expected) {
            expectedID.add(exp.getId());
        }
        Assertions.assertEquals(itemsID, expectedID);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(0, new Item(111, "A111"));
        items.add(1, new Item(222, "B222"));
        items.add(2, new Item(333, "C333"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(0, new Item(333, "C333"));
        expected.add(1, new Item(222, "B222"));
        expected.add(2, new Item(111, "A111"));
        ArrayList<Integer> itemsID = new ArrayList<>();
        for (Item item : items) {
            itemsID.add(item.getId());
        }
        ArrayList<Integer> expectedID = new ArrayList<>();
        for (Item exp : expected) {
            expectedID.add(exp.getId());
        }
        Assertions.assertEquals(itemsID, expectedID);
    }
}
