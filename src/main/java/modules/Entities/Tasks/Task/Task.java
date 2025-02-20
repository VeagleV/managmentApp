package modules.Entities.Tasks.Task;

import modules.Entities.Tasks.TaskEnums.*;
import modules.Entities.User.User;
import org.hibernate.SessionFactory;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import static java.util.logging.Level.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="tasks")
public class Task {

    public static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    @Id
    protected final Integer id;

    @Column(name="name",nullable = false)
    protected String name;

    @Column(name="status", nullable = false)
    protected TaskStatus status; // Complete/ InProcess /

    @Column(name="description")
    protected String description;

    @Column(name="creationTime", nullable = false)
    protected final LocalDateTime creationTime;

    @Column(name = "plannedTime")
    private LocalDateTime plannedTime;

    @ManyToOne
    @JoinColumn(name = "userid") // Поле внешнего ключа в таблице tasks
    private User user;

    private SessionFactory sessionFactory;

    private static Integer counter = 0;

    //----------------------CONSTRUCTORS----------------------
    public Task() {
        this.creationTime = LocalDateTime.now();
        this.id = counter++;
    }

    public Task(Integer statusID, String name, String description) {
        this();
        this.status = TaskStatus.values()[statusID];
        this.name = name;
        this.description = description;
    }

    public Task(Integer statusID, String name, String description, LocalDateTime plannedTime) {
        this();
        this.status = TaskStatus.values()[statusID];
        this.name = name;
        this.description = description;
        this.plannedTime = plannedTime;
    }


    //----------------------CONSTRUCTORS----------------------

    //----------------------GETTERS/SETTERS----------------------
    public String getName() {
        LOGGER.log(INFO,"returned name");
        return name;
    }

    public TaskStatus getStatus() {
        LOGGER.log(INFO,"returned status");
        return status;
    }

    public String getDescription() {
        LOGGER.log(INFO,"returned description");
        return description;
    }

    public Integer getId() {
        LOGGER.log(INFO,"returned ID");
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreationTime() {
        LOGGER.log(INFO,"returned creationTime");
        return creationTime;
    }

    public void setName(String name) {
        LOGGER.log(INFO,"Name set");
        this.name = name;
    }

    public void setStatus(TaskStatus status){
        LOGGER.log(INFO,"Status set");
        this.status = status;
    }

    public void setDescription(String description){
        LOGGER.log(INFO,"Description set");
        this.description = description;
    }
    //----------------------GETTERS/SETTERS----------------------

}
