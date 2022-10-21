package ru.job4j.tracker;

import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemComparatorTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = List.of(
        new Item(1, "one"),
        new Item(4, "four"),
        new Item(5, "five")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = List.of(
        new Item(5, "five"),
        new Item(4, "four"),
        new Item(1, "one")
        );
        assertThat(items).hasSameElementsAs(expected);
    }
}
