package modules.ConsoleService;

import modules.User.User;
import modules.Service.UserService;
import java.util.Scanner;

public class ConsoleMenu {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);
    private User currentUser = null;

    public void start() {
        while (true) {
            if (currentUser == null) {
                showLogInMenu();
            } else {
                showTaskMenu();
            }
        }
    }

    private void showLogInMenu() {
        System.out.println("1. Вход");
        System.out.println("2. Регистрация");
        System.out.println("0. Выход");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> login();
            case 2 -> register();
            case 0 -> System.exit(0);
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void login() {
        System.out.print("Имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        currentUser = userService.login(username, password);
        if (currentUser == null) {
            System.out.println("Неверный логин или пароль.");
        }
    }

    private void register() {
        System.out.print("Имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        if (userService.register(username, password)) {
            System.out.println("Регистрация прошла успешно.");
        } else {
            System.out.println("Пользователь уже существует.");
        }
    }

    private void showTaskMenu() {
        System.out.println("1. Профиль");
        System.out.println("2. Просмотреть задачи");
        System.out.println("3. Добавить задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("0. Выйти");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> showProfile();
            case 2 -> viewTasks();
            case 3 -> addTask();
            case 4 -> deleteTask();
            case 0 -> System.exit(0);
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void showProfile() {
        System.out.println("ID: " + currentUser.getId());
        System.out.println("name: " + currentUser.getName());
        System.out.println("login: " + currentUser.getLogin());

    }

    private void addTask() {
        //каминг сун на лицо
    }

    private void viewTasks() {
        //каминг сун на лицо
    }

    private void deleteTask() {
        //каминг сун на лицо
    }
}

