package modules.User;


import org.hibernate.SessionFactory;
import jakarta.persistence.*;
import java.util.logging.Logger;

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

    private static Integer counter = 2;

    private SessionFactory sessionFactory;

    public static final Logger LOGGER = Logger.getLogger(User.class.getName());

    //----------------------CONSTRUCTORS----------------------
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
    //----------------------CONSTRUCTORS----------------------

    //----------------------GETTERS\SETTERS----------------------
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

    public void setName(String name){
        this.name = name;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    //----------------------GETTERS\SETTERS----------------------
}
