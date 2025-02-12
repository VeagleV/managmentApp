package modules.DataBaseProcessor.Services.ConsoleService;

import modules.Entities.Tasks.TimedTask.TimedTask;
import modules.Entities.User.User;
import modules.Entities.Tasks.Task.Task;
import modules.DataBaseProcessor.Services.UserService.UserService;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Set;

public class ConsoleService {
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

        currentUser = UserService.login(username, password);
        if (currentUser == null) {
            System.out.println("Неверный логин или пароль.");
        }
    }

    private void register() {
        System.out.print("Имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        //TODO: Добавить хеширование пароля(sha-256)

        if (UserService.register(username, password)) {
            System.out.println("Регистрация прошла успешно.");
        } else {
            System.out.println("Пользователь уже существует.");
        }
    }

    private void showTaskMenu() {
        System.out.println("1. Профиль");
        System.out.println("2. Просмотреть задачи");
        System.out.println("3. Добавить задачу");
        System.out.println("0. Выйти");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> showProfile();
            case 2 -> viewTasks();
            case 3 -> addTask();
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
        System.out.println("Название задачи: ");
        String taskName = scanner.nextLine();

        System.out.println("Статус:\n1.Запланированно;\n2.В процессе;\n3.Отложенное;\n4.Выполнен");
        int taskStatus = -1;
        while (taskStatus == -1) {
            try{
                System.out.println("\nВыбор: ");
                taskStatus = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                taskStatus = -1;
            }
        }

        System.out.println("Описание: ");
        String taskDescription = scanner.nextLine();

        System.out.println("Дедлайн: ");
        System.out.println("Год: ");
        String year = scanner.nextLine();

        System.out.println("Месяц");
        String month = scanner.nextLine();

        System.out.println("День");
        String day = scanner.nextLine();

        System.out.println("Время(HH:mm:ss): ");
        String hour = scanner.nextLine();

        String str = year + "-" + month + "-" + day + " " + hour;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        Task task = new TimedTask(taskStatus, taskName, taskDescription, dateTime);
        currentUser.addTask(task);
        UserService.save(currentUser);

    }

    private void viewTasks() {
        Set<Task> tasks = currentUser.getTasks();
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("name: " + task.getName());
            System.out.println("description: " + task.getDescription());
            System.out.println("status: " + task.getStatus() + "\n");
        }
        System.out.println("Введите id таска для входа в него(0 - выход): ");
        int id = Integer.parseInt(scanner.nextLine());
        if(id == 0) return;
        for (Task task : currentUser.getTasks()) {
            if (task.getId() == id) {
                System.out.println("1.Переустановить статус\n2.Удалить задачу");
                int choice = Integer.parseInt(scanner.nextLine());
                //afasdfasf
            }
        }
    }

    private void deleteTask() {
        //каминг сун на лицо
    }
}

