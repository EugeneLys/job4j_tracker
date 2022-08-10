package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User searchedUser = null;
        for (int index = 0; index < users.length; index++) {
            if (login.equals(users[index].getUsername())) {
                searchedUser = users[index];
                break;
            }
        }
        if (searchedUser == null) {
            throw new UserNotFoundException("No user with such name");
        }
        return searchedUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = user.isvalid();
        if ((user.getUsername()).length() < 3 || !rsl) {
            throw new UserInvalidException("User is not valid");
        }
        return rsl;
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
