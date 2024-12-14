package modules.Tasks;

import java.time.LocalDateTime;
import modules.Tasks.TaskStatus;
public abstract class Task {

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
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreationTime() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(TaskStatus status){
        this.status = status;
    }

    public void setDescription(String description){
        this.description = description;
    }


}
