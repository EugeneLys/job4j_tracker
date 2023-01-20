package ru.job4j.bank;


import java.util.*;

/**
 * Класс описывает банковскую систему (сервис) и методы управления
 * ее составляющими (данными о клиентах и их счетах, переводами и т.д.)
 */
public class BankService {
    /**
     * Хранение данных всех клиентов происходит в карте,
     * содержащей список всех счетов клиентов с поиском по ключу User
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового клиента в систему
     * @param user новый уникальный клиент
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод открывает новый счет клиенту
     * @param passport номер паспорта клиента для его идентификации
     * @param account новый счет клиента
     */
    public void addAccount(String passport, Account account) {
        User u = findByPassport(passport);
        if (users.get(u)
                .stream()
                .noneMatch(a -> a.getRequisite().equals(account.getRequisite()))) {
            users.get(u).add(account);
        }
    }

    /**
     * Метод поиска клиента в системе
     * @param passport номер паспорта клиента
     * @return возвращает ссылку на клиента с таким номером паспорта
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод для поиска конкретного счета конкретного клиента
     * @param passport номер паспорта клиента для его поиска
     * @param requisite номер счета этого клиента
     * @return возвращает ссылку на требуемый счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод для перевода средств с любого счета на любой счет в системе
     * @param srcPassport номер паспорта клиента, который переводит средства
     * @param srcRequisite номер счета, с которого переводятся средства
     * @param destPassport норме паспорта клиента, которому переводятся средства
     * @param destRequisite номер счета, на который переводятся средства
     * @param amount сумма перевода
     * @return возвращает результат работы метода (осуществлен перевод или нет)
     */
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

    /**
     * Метод для получения списка счетов клиента
     * @param user интересующий клиент
     * @return возвращает список счетов этого клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}