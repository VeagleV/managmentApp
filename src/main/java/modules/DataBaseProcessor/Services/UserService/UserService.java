package modules.DataBaseProcessor.Services.UserService;

import modules.DataBaseProcessor.DataAccess.UserDataAccess.UserDataAccess;
import modules.Entities.User.User;

public class UserService {
    private static final UserDataAccess userDA = new UserDataAccess();

    public static User login(String login, String password) {
        User user = userDA.getByLoginAndPassword(login, password);
        return user;
    }


    public static boolean register(String login, String password) {
        if (userDA.getByLogin(login) != null) {
            return false; // Пользователь уже существует
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userDA.save(user);
        return true;
    }

    public void save(User currentUser) {
        userDA.save(currentUser);
    }
}
