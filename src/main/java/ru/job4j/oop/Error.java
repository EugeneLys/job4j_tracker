package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error typo = new Error();
        Error critical = new Error(true, 404, "Restart the computer");
        Error serious = new Error(true, 303, "Wait a minute");
        Error mistake = new Error(false, 500, "Try again");
        typo.printInfo();
        critical.printInfo();
        serious.printInfo();
        mistake.printInfo();
    }
}
