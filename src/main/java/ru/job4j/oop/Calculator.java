package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + minus(d) + multiply(d) + divide(d);
    }

    public static void main(String[] args) {
        int addition = sum(10);
        int subtraction = minus(10);
        Calculator calculator = new Calculator();
        int multiplication = calculator.multiply(10);
        int division = calculator.divide(10);
        int consolidated = calculator.sumAllOperation(10);
        System.out.println("Calculations when 10 is the argument:");
        System.out.println("addition = " + addition);
        System.out.println("subtraction = " + subtraction);
        System.out.println("multiplication = " + multiplication);
        System.out.println("division = " + division);
        System.out.println("sum of all calculations = " + consolidated);
    }
}
