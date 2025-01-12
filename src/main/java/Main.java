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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modules.DataBaseProcessor.HibernateUtil;

import static java.lang.Thread.sleep;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {


    //TODO: Сохранение бд в файл(две бд(1 значение - айди юзера)
    //TODO: Консольный интерфейс
        //абаюмба

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User newUser = new User();
        newUser.setLogin("admin");
        newUser.setName("test");
        newUser.setPassword("123");

        session.save(newUser);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();

    }
}