package modules.Tasks;

import java.time.LocalDateTime;

public abstract class Task {

    protected Integer id;
    protected String name;
    protected String status; // Complete/ InProcess /
    protected String description;
    protected final LocalDateTime creationTime;

    protected Task() {
        this.creationTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
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

    public void setStatus(String status){
        this.status = status;
    }
    public void setDescription(String description){
        this.description = description;
    }


}
