package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByRequisite(user.getPassport(), account.getRequisite()) == null) {
            users.get(user).add(new Account(account.getRequisite(), account.getBalance()));
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> deposits = new ArrayList<>();
        if (user != null) {
            deposits.addAll(users.get(user));
            for (Account required : deposits) {
                if (required.getRequisite().equals(requisite)) {
                    return required;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null || src.getBalance() < amount) {
            return false;
        }
        src.setBalance(src.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}