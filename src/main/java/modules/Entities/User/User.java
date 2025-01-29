package modules.Entities.User;



import java.util.HashSet;
import org.hibernate.SessionFactory;
import jakarta.persistence.*;

import java.util.Set;
import java.util.logging.Logger;
import modules.Entities.Tasks.Task.Task;


@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", length = 50)
    private String name;

    @Column(name="login", nullable = false,length = 50)
    private String login;

    @Column(name="password", nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks = new HashSet<Task>();

    private static Integer counter = 0;

    private static User instance;

    private SessionFactory sessionFactory;

    public static final Logger LOGGER = Logger.getLogger(User.class.getName());

    //----------------------CONSTRUCTORS----------------------
    public User(){}
     /*
     public User() {
        this.id = counter++;
//        startCheckingTasks();

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

      */
    //----------------------CONSTRUCTORS----------------------

    //----------------------GETTERS\SETTERS----------------------

    public static User getInstance(){
        if(instance == null){
            synchronized (User.class){
                if(instance == null){
                    instance = new User();
                }
            }
        }
        return instance;
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

    public String getName(){
        return name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        for (Task task : tasks) {
            task.setUser(this); // Устанавливаем обратную связь
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setUser(this); // Устанавливаем обратную связь
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.setUser(null); // Убираем обратную связь
    }

    public void setName(String name){
        this.name = name;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    //----------------------GETTERS\SETTERS----------------------

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (!this.login.equals(user.getLogin())) {
            return false;
        }
        if (!this.password.equals(user.getPassword())) {
            return false;
        }
        if (!this.name.equals(user.getName())) {
            return false;
        }
        if (!this.id.equals(user.getId())) {
            return false;
        }
        return true;
    }

}
