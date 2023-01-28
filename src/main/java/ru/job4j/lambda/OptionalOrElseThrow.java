package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException {
    }

    public static User orElseThrow(List<User> list, String login) {
        Optional<User> var = search(list, login);
        if (var.isEmpty()) {
            throw new OptionalOrElseThrow.UserNotFoundException();
        }
        return var.get();
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();
        Optional<User> var = list.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        return var.isEmpty() ? user : var;
    }

}
