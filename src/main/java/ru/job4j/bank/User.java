package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка (банковского сервиса)
 * @author EUGENE LYSAKOV
 * @version 1.0
 */
public class User {
    /**
     * Поля класса, содержащие уникальные характеристики клиента
     * для его идентификации
     */
    private String passport;
    private String username;

    /**
     * Конструктор для регистрации клиента в банковской системе
     * Присваиваемые при регистрации значения характеристик:
     * @param passport номер паспорта клиента
     * @param username имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения номера паспорта интересующего клиента
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для присвоения номера паспорта клиента
     * @param passport новое значение номера паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения имени клиента
     * @return возвращает значение поля username клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для изменения (присваивания) имени клиента
     * @param username присваиваемое клиенту имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод для идентификации клиента (подтверждения его личности)
     * в системе
     * @param o принимаемый методом объект User
     * @return возвращает результат сравнения двух клиентов (true или false)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод для получения уникального кода, присвоенного клиенту (User)
     * при его создании
     * @return возвращает этот уникальный код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
