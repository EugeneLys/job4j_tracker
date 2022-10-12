package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotifyAccountTest {
    @Test
    public void whenTwoAccountsAddSent() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(notifyAccount.sent(accounts)).containsAll(expect);
    }

    @Test
    public void whenThreeAccountsBecomesTwo() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> list = Arrays.asList(
                new Account("123", "Petr Arsentev", "1"),
                new Account("456", "Petr Arsentev", "333"),
                new Account("123", "Petr Arsentev", "999999999")
        );
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "1"),
                        new Account("456", "Petr Arsentev", "333")
                )
        );
        assertThat(notifyAccount.sent(list)).containsAll(expected);
    }
}