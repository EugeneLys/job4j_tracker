package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book java = new Book("Java in a nutshell", 1000);
        Book sharp = new Book("C# in a nitshell", 1200);
        Book basic = new Book("Basic in a nitshell", 2000);
        Book clean = new Book("Clean code", 10000);
        Book[] lib = new Book[4];
        lib[0] = java;
        lib[1] = sharp;
        lib[2] = basic;
        lib[3] = clean;
        System.out.println("My library at first: ");
        for (int index = 0; index < lib.length; index++) {
            System.out.println("\"" + lib[index].getTitle() + "\"" + ", " + lib[index].getPages() + " pages.");
            if (index == lib.length - 1) {
                System.out.println();
            }
        }
        Book temp;
        temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        System.out.println("My library after change: ");
        for (int index = 0; index < lib.length; index++) {
            System.out.println("\"" + lib[index].getTitle() + "\"" + ", " + lib[index].getPages() + " pages.");
            if (index == lib.length - 1) {
                System.out.println();
            }
        }
        System.out.println("Only books with the title 'Clean code':");
        for (int index = 0; index < lib.length; index++) {
            if (lib[index].getTitle().equals("Clean code")) {
                System.out.println("\"" + lib[index].getTitle() + "\"" + ", " + lib[index].getPages() + " pages.");
            }
        }
    }
}
