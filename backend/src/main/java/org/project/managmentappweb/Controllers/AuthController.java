package org.project.managmentappweb.Controllers;

import org.project.managmentappweb.DataTransfers.UserLoginDTO;
import org.project.managmentappweb.DataTransfers.UserRegistrationDTO;
import org.project.managmentappweb.Entities.User.User;
import org.project.managmentappweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDTO userDTO) {
        userService.registerUser(userDTO);
        return ResponseEntity.ok("Проверьте вашу почту для подтверждения аккаунта!");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam String token) {
        boolean isVerified = userService.verifyAccount(token);
        if (isVerified) {
            return ResponseEntity.ok("Аккаунт успешно подтвержден!");
        } else {
            return ResponseEntity.status(400).body("Неверный или просроченный токен.");
        }
    }

    @PostMapping("/resend-verification")
    public ResponseEntity<String> resendVerificationEmail(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        userService.resendVerificationEmail(email);
        return ResponseEntity.ok("Письмо с подтверждением отправлено повторно!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO loginRequest) {
        boolean isAuthenticated = userService.authenticate(loginRequest.getLogin(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}