package modules;
import modules.Tasks.Task;
import modules.Tasks.Timed.TimedTask;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Entity
@Table(name="users")
public class User {

    @Id
    private final Integer id;

    @Column(name="name")
    private String name;

    @Column(name="login",nullable = false,length = 32)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

    private static Integer counter = 0;


    private HashMap<Integer, Task> tasks = new HashMap<>();


    private ScheduledExecutorService scheduler;

    private SessionFactory sessionFactory;

    public static final Logger LOGGER = Logger.getLogger(User.class.getName());

    public User() {
        this.id = counter++;
        //startCheckingTasks();

//        this.sessionFactory = new Configuration()
//                .configure()
//                .buildSessionFactory();

    }

    public User(String login, String password){
        this();
        this.login = login;
        this.name = login;
        this.password = password;
    }

    public User(String login, String password, String name){
        this();
        this.login = login;
        this.password = password;
        this.name = name;
    }


    //Запускает проверку на то, что задача просрочена, раз в секунду
//    public void startCheckingTasks() {
//        scheduler.scheduleAtFixedRate(()->{
//
//            for(int i = 0; i < tasks.size(); i++){
//
//                Task currentTask = (Task) Arrays.asList(tasks.values()).get(i);
//
//                if(currentTask instanceof TimedTask currentTimedTask){
//
//                    currentTimedTask.updatePlannedTime();
//
//                }
//            }
//        },0,1,TimeUnit.SECONDS);
//    }

    public void stopCheckingTasks(){

    }




    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public Integer getId(){
        return id;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void assignTask(Task task) {

        if( tasks.containsKey(task.getId())) {

            throw new RuntimeException("This task is already assigned to this User");

        }

        this.tasks.put(task.getId(), task);
    }

    public void depriveTask(Task task){
        if(!tasks.containsKey(task.getId())){

            throw new RuntimeException("There is no such assigned task to this User");

        }

        tasks.remove(task.getId());

    }
    //думаю нужен новый класс, который будет получать 1) Проверять наличие пользователя с бд и его логин
    // и пароль, 2) Добавлять в случае если юзер новый, 3) получать таски из бд, 4)добавлять таски в бд
    //Получение тасков из бд(пизжено. Понять+переделать)



    public List<Task> getAllTasks(){

//        try(Session session = sessionFactory.openSession()){
//            Query<Task> query = session.createQuery("from task", Task.class);
//            return query.list();
//        }

        return List.of();
    }

    //Добавление таска в базу(пизжено. Понять+переделать)
    public void addTask(Task task){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        }
    }


}
