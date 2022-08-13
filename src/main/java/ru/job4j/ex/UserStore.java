package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User searchedUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                searchedUser = user;
                break;
            }
        }
        if (searchedUser == null) {
            throw new UserNotFoundException("No user with such name");
        }
        return searchedUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isvalid()) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Evgeny Lysakov", true)
        };
        try {
            validate(findUser(users, "Petr Arsentev"));
            System.out.println("This user has an access");
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
