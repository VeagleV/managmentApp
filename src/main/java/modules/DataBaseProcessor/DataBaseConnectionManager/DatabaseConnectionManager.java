package modules.DataBaseProcessor.DataBaseConnectionManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnectionManager {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Создаем SessionFactory из hibernate.cfg.xml
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //закрытие кеша и соединений
    public static void shutdown() {
        getSessionFactory().close();
    }
}

