import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.HashSet;
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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modules.DataBaseProcessor.HibernateUtil;


import static java.lang.Thread.sleep;

public class Main {

        public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
        static Session session = HibernateUtil.getSessionFactory().openSession();
        static User user = new User();

        public static void createUser(){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            user.setName(name);

            System.out.println("Please enter your login: ");
            String login = scanner.nextLine();
            user.setLogin(login);

            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
            user.setPassword(password);

            session.save(user);
            session.getTransaction().commit();
        }

        public static void findUser() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your login: ");
            String login = scanner.nextLine();
            user.setLogin(login);

            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
            user.setPassword(password);
            Query<User> query = session.createQuery(
                    "from User where login = :loginParam and password = :passwordParam",
                    User.class
            );
            query.setParameter("loginParam", login);
            query.setParameter("passwordParam", password);

            user = query.uniqueResult();

            if (user != null) {
                // Пользователь найден
                System.out.println("User found: ID = " + user.getId() + ", Name = " + user.getName());
            } else {
                // Пользователь не найден
                System.out.println("User not found: Invalid login or password.");
            }

            // Завершаем транзакцию
            session.getTransaction().commit();
        }


        public static void main(String[] args) {

            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            while (choice != 0) {
                System.out.println("1. Регистрация");
                System.out.println("2. Войти");
                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                }
                else{
                    System.out.println("INVALID INPUT");
                    continue;
                }
                switch(choice){
                    case 1:
                        createUser();

                        break;
                    case 2:
                        findUser();

                        break;
                    default: System.out.println("INVALID INPUT"); break;
                }
            }

            session.getTransaction().commit();
            session.close();

            HibernateUtil.shutdown();

        }
}