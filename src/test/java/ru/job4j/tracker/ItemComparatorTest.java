package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemComparatorTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "one"));
        items.add(new Item(4, "four"));
        items.add(new Item(5, "five"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(5, "five"));
        expected.add(new Item(4, "four"));
        expected.add(new Item(1, "one"));
        Assertions.assertTrue();
    }
}
