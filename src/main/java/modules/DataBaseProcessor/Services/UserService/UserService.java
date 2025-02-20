package modules.DataBaseProcessor.Services.UserService;

import modules.DataBaseProcessor.DataAccess.UserDataAccess.UserDataAccess;
import modules.Entities.User.User;
import modules.Hashing.PasswordHashing;
import modules.repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) { // Изменили тип возвращаемого значения на Optional<User>
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public static User login(String login, String password) {
        return UserDataAccess.getByLoginAndPassword(login, PasswordHashing.hashPassword(password));
    }


    public static boolean register(String login, String password) {
        if (UserDataAccess.getByLogin(login) != null) {
            return false; // Пользователь уже существует
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(PasswordHashing.hashPassword(password));
        UserDataAccess.save(user);
        return true;
    }

    public static void save(User currentUser) {
        UserDataAccess.save(currentUser);
    }
}
