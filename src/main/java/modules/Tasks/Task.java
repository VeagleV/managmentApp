package modules.Tasks;
import modules.Tasks.Timed.TimedTask;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import static java.util.logging.Level.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Task{

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

    @Column(name="userID")
    private Integer userID;

    private SessionFactory sessionFactory;

    private static Integer counter = 0;

    protected Task() {
        this.creationTime = LocalDateTime.now();
        this.id = counter++;
    }

    protected Task(Integer statusID, String name, String description){
        this();
        this.status = TaskStatus.values()[statusID];
        this.name = name;
        this.description = description;
    }





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


    public static TimedTask assignTimeToTimelessTask(Task task, LocalDateTime plannedTime){


        TimedTask newTask = new TimedTask();

        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setPlannedTime(plannedTime);

        LOGGER.log(INFO,"TimelessTask is morphed to the TimedTask(ID is updated, all old fields kept");
        return newTask;

    }


}
