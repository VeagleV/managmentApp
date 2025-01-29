package modules.DataBaseProcessor.DataAccess.TaskDataAccess;

import modules.DataBaseProcessor.DataBaseConnectionManager.DatabaseConnectionManager;
import org.hibernate.Session;

public class TaskDataAccess {
    Session session = DatabaseConnectionManager.getSessionFactory().openSession();

}
