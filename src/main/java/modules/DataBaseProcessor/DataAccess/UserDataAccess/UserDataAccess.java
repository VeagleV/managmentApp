package modules.DataBaseProcessor.DataAccess.UserDataAccess;

import modules.Entities.User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modules.DataBaseProcessor.DataBaseConnectionManager.DatabaseConnectionManager;

public interface UserDataAccess {
    Session session = DatabaseConnectionManager.getSessionFactory().openSession();

    //TODO: ПОФИКСИТЬ(НЕ РАБОТАЕТ С ХЕШАМИ)
    static User getByLoginAndPassword(String login, String password) {
        return session.createQuery("FROM User WHERE login= :login and password= :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .uniqueResult();
    }

    static User getByLogin(String login) {
        return session.createQuery("FROM User WHERE login= :login", User.class)
                .setParameter("login", login)
                .uniqueResult();
    }

    static void save(User user) {
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
    }

}
