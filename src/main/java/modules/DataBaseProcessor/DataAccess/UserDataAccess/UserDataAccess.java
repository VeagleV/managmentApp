package modules.DataBaseProcessor.DataAccess.UserDataAccess;

import modules.Entities.User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modules.DataBaseProcessor.DataBaseConnectionManager.DatabaseConnectionManager;

public class UserDataAccess {
    Session session = DatabaseConnectionManager.getSessionFactory().openSession();

    public User getByLoginAndPassword(String login, String password) {
        return session.createQuery("FROM User WHERE login= :login and password= :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .uniqueResult();
    }
    public User getByLogin(String login) {
        return session.createQuery("FROM User WHERE login= :login", User.class)
                .setParameter("login", login)
                .uniqueResult();
    }
    public void save(User user) {
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

}
