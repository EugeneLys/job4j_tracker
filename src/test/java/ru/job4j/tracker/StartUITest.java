package ru.job4j.tracker;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(
                "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit program" + ln
                        + "=== Replace item ===" + ln
                        + "Item sucessfully replaced." + ln
                        + "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit program" + ln
                        + "Program execution is finished" + ln,
                out.toString()
        );
    }

    @Test
    public void whenShowActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = List.of(
        new ShowAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(
                "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit program" + ln
                        + "Program execution is finished" + ln,
                out.toString()
        );
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", one.getName(), "1"}
        );
        List<UserAction> actions = List.of(
        new FindByNameAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit program" + ln
                        + "=== Find item by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit program" + ln
                        + "Program execution is finished" + ln,
                out.toString()
        );
    }

    @Test
    public void whenFindByIDActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = List.of(
        new FindByIDAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit program" + ln
                        + "Program execution is finished" + ln,
                out.toString()
        );
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
        new CreateAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        Assert.assertEquals(tracker.findAll().get(0).getName(), "Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = List.of(
        new ReplaceAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        Assert.assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
        new DeleteAction(out),
        new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu:" + ln
                        + "0. Exit program" + ln
                        + "Wrong input, you can select: 0 ... 0" + ln
                        + "Menu:" + ln
                        + "0. Exit program" + ln
                        + "Program execution is finished" + ln
        );
    }
}