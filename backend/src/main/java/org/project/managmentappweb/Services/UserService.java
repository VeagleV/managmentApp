package org.project.managmentappweb.Services;


import org.project.managmentappweb.DataTransfers.UserRegistrationDTO;
import org.project.managmentappweb.Entities.User.User;
import org.project.managmentappweb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;


    public void registerUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(false);

        // Генерация токена
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);

        userRepository.save(user);

        // Отправка письма
        emailService.sendVerificationEmail(user.getEmail(), token);
    }

    public boolean verifyAccount(String token) {
        User user = userRepository.findByVerificationToken(token);
        if (user != null && !user.isEnabled()) {
            user.setEnabled(true);
            user.setVerificationToken(null); // Очищаем токен после подтверждения
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void resendVerificationEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null && !user.isEnabled()) {
            String token = UUID.randomUUID().toString();
            user.setVerificationToken(token);
            userRepository.save(user);

            emailService.sendVerificationEmail(user.getEmail(), token);
        } else {
            throw new RuntimeException("Пользователь уже активирован или не найден.");
        }
    }

    public boolean authenticate(String login, String password) {
        User user = userRepository.findByLogin(login);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}