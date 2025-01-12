import java.util.logging.Logger;

import modules.User.User;
import org.hibernate.Session;
import modules.DataBaseProcessor.HibernateUtil;


public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {


    //TODO: Сохранение бд в файл(две бд(1 значение - айди юзера)
    //TODO: Консольный интерфейс
        //абаюмба

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User newUser = new User();
        newUser.setLogin("хуйmin");
        newUser.setName("test");
        newUser.setPassword("123");

        session.save(newUser);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();

    }
}