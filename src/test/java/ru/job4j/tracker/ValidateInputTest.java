package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertEquals(selected, 1);
        /* Проверка "пойманного" исключения NFE при вводе "one": */
        Assertions.assertEquals(out.toString(), "Please enter validate data again."
                + System.lineSeparator());
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertEquals(selected, 1);
        Assertions.assertEquals(out.toString(), "");
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertEquals(selected, 1);
        selected = input.askInt("Enter menu:");
        Assertions.assertEquals(selected, 2);
        Assertions.assertEquals(out.toString(), "");
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertEquals(selected, -1);
        Assertions.assertEquals(out.toString(), "");
    }
}