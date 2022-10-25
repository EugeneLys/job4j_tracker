package ru.job4j.bank;


import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 */
public class Account {
    /**
     * счету присваивается номер
     * и устанавливается баланс
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор для создания счета
     * @param requisite присваиваемый номер счета
     * @param balance устанавливаемый баланс средств на счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения номера счета
     * @return возвращает значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для присваивания (изменения) номера счету
     * @param requisite новый номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения состояния счета
     * @return возвращает значения поля balance счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для установления (изменения) баланса счета
     * @param balance присваиваемое значение поля balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод для сравнения счетов
     * @param o счет, принимаемый для сравнения с текущим
     * @return возвращает результат сравнения (идентичности) счетов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод для получения уникального кода, присваиваемого счету при создании
     * @return возвращает этот код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
