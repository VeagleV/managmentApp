package modules.DataBaseProcessor.Services.UserService;

import modules.DataBaseProcessor.DataAccess.UserDataAccess.UserDataAccess;
import modules.Entities.User.User;

public class UserService {
    private final UserDataAccess userDA = new UserDataAccess();

    public User login(String username, String password) {
        User user = userDA.getByLoginAndPassword(username, password);
        return user;
    }

    public boolean register(String login, String password) {
        if (userDA.getByLogin(login) != null) {
            return false; // Пользователь уже существует
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userDA.save(user);
        return true;
    }
}
