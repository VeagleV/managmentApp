package modules;
import javax.swing.text.StyledEditorKit;
import java.util.Calendar;
import java.time.LocalDateTime;

public class Task {

    private Integer id;
    private String name;
    private String status;
    private String description;

    private final LocalDateTime creationTime;
    private LocalDateTime plannedTime;

    private Boolean isExpired = false;


    Task(String name, String status, String description, Integer id, LocalDateTime plannedTime){
        this.name = name;
        this.status = status;
        this.description = description;
        this.id = id;
        this.plannedTime = plannedTime;
        this.creationTime = LocalDateTime.now();
    }

    Task(String name, String status, String description, Integer id){
        this.name = name;
        this.status = status;
        this.description = description;
        this.id = id;
        this.creationTime = LocalDateTime.now();
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getDescription(){
        return description;
    }

    public Integer getId() { return id; }

    public LocalDateTime getPlannedTime() { return plannedTime; }

    public LocalDateTime getCreationTime() { return creationTime; }



    public void setName(String name){
        this.name = name;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPlannedTime(LocalDateTime plannedTime){
        this.plannedTime = plannedTime;
    }

    public boolean isExpired(){

        updateTime();

        return isExpired;
    }

    private void updateTime(){

        LocalDateTime currentTime= LocalDateTime.now();

        if(plannedTime.isAfter(currentTime)){
            isExpired = true;
            status = "Expired";

        }
    }





}


