package org.project.managmentappweb.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Async
    public void sendVerificationEmail(String to, String token) {
        try {
            LOGGER.info("Начало отправки письма на адрес: {}", to);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Подтверждение аккаунта");
            message.setText("Для подтверждения аккаунта перейдите по ссылке: "
                    + "http://localhost:8081/verify?token=" + token);
            mailSender.send(message);
            LOGGER.info("Письмо успешно отправлено на адрес: {}", to);
        } catch (Exception e) {
            LOGGER.error("Ошибка при отправке письма: ", e);
            throw new RuntimeException("Не удалось отправить письмо.");
        }
    }
}