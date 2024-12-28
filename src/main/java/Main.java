import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import modules.LogCreator.LogCreator;
import modules.Tasks.Task;
import modules.Tasks.TaskFactory;
import modules.Tasks.TaskType;
import modules.Tasks.Timed.TimedTask;
import modules.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import static java.lang.Thread.sleep;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {


    //TODO: Сохранение бд в файл(две бд(1 значение - айди юзера)
    //TODO: Консольный интерфейс
        //абаюмба

       //Заглушка для проверки функционала
        LogCreator log = new LogCreator(); // Данная строка **обязательна** для конфигурации логгера

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        while(true) {
            System.out.println("АВТОРИЗАЦИЯ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.РЕГАТЬСЯ");
            System.out.println("2.НЕРЕГАТЬСЯ");
            System.out.print("ВЫБОР: ");
            Integer choice = scanner.nextInt();
            System.out.print("LOGIN: ");
            String login = scanner.next();
            System.out.print("PASSWORD: ");
            String password = scanner.next();
            if(choice == 1) {
                //тут запрос на добавление
            }
            if(choice == 2) {
                //тут проверку на существование
            }



        }


    }
}