package modules.DataBaseProcessor.Services.UserService;

import modules.DataBaseProcessor.DataAccess.UserDataAccess.UserDataAccess;
import modules.Entities.User.User;
import modules.Hashing.PasswordHashing;

public interface UserService {

    static User login(String login, String password) {
        return UserDataAccess.getByLoginAndPassword(login, PasswordHashing.hashPassword(password));
    }


    static boolean register(String login, String password) {
        if (UserDataAccess.getByLogin(login) != null) {
            return false; // Пользователь уже существует
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(PasswordHashing.hashPassword(password));
        UserDataAccess.save(user);
        return true;
    }

    static void save(User currentUser) {
        UserDataAccess.save(currentUser);
    }
}
