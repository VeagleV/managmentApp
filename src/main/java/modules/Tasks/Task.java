package modules.Tasks;
import modules.Tasks.Timed.TimedTask;

import java.time.LocalDateTime;
import java.util.logging.Logger;
import static java.util.logging.Level.*;

public abstract class Task{

    public static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    protected final Integer id;
    protected String name;
    protected TaskStatus status; // Complete/ InProcess /
    protected String description;
    protected final LocalDateTime creationTime;
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
