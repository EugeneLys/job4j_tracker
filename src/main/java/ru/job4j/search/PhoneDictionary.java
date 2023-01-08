package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> nameCheck = p -> p.getName().contains(key);
        Predicate<Person> surnameCheck = p -> p.getSurname().contains(key);
        Predicate<Person> phoneCheck = p -> p.getPhone().contains(key);
        Predicate<Person> addressCheck = p -> p.getAddress().contains(key);
        Predicate<Person> combine = nameCheck.or(surnameCheck.or(phoneCheck.or(addressCheck)));
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}