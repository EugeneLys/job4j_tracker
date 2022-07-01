package ru.job4j.pojo;

import java.util.Date;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Eugene Lysakov");
        student.setGroup(1);
        student.setEnter(new Date());
        System.out.println("Студент: " + student.getName()
                + ", номер группы: " + student.getGroup() + ", дата поступления: " + student.getEnter());
    }
}
