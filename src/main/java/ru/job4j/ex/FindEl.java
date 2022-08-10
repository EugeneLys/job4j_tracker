package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("No such element in the array.");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws  ElementAbuseException {
        for (int index = 0; index < abuses.length; index++) {
            if (value.equals(abuses[index])) {
                throw new ElementAbuseException("");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] words = new String[] {"first", "second", "third"};
        try {
            indexOf(words, "fourth");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
