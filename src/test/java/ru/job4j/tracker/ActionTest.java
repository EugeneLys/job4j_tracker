package ru.job4j.tracker;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActionTest {

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        Assertions.assertEquals(output.toString(),
                "=== Replace item ===" + ln
                        + "Item successfully replaced." + ln
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction delete = new DeleteAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        delete.execute(input, tracker);

        String ln = System.lineSeparator();
        Assertions.assertEquals(output.toString(),
                "=== Delete item ===" + ln
                        + "Item successfully deleted." + ln
        );
    }

    @Test
    public void whenFindByIdWasOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIDAction findByIDAction = new FindByIDAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        Assertions.assertEquals(output.toString(),
                "=== Find item by id ===" + ln
                        + "Item{id=1, name='Item', created=" + item.getCreated().format(formatter)
                        + "}" + ln);
    }

    @Test
    public void whenFindByNameWasOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        Assertions.assertEquals(output.toString(),
                "=== Find item by name ===" + ln
                        + "Item{id=1, name='Item', created=" + item.getCreated().format(formatter)
                        + "}" + ln);
    }
}
