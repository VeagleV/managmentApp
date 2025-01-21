
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modules.User.User;
import org.hibernate.Session;
import modules.DataBaseProcessor.HibernateUtil;
import org.hibernate.query.Query;
import modules.ConsoleService.ConsoleMenu;


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

            ConsoleMenu menu = new ConsoleMenu();
            menu.start();

            session.close();

            HibernateUtil.shutdown();

        }
}