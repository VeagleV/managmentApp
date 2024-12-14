package modules.Tasks.Timeless;

import modules.Tasks.Task;

import java.time.LocalDateTime;

public class TimelessTask extends Task{

    private Integer id;
    private String name;
    private String status;
    private String description;

    private final LocalDateTime creationTime;
    private LocalDateTime plannedTime;

    private Boolean isExpired = false;

    TimelessTask(String name, String status, String description, Integer id, LocalDateTime plannedTime){
        this.name = name;
        this.status = status;
        this.description = description;
        this.id = id;
        this.plannedTime = plannedTime;
        this.creationTime = LocalDateTime.now();
    }

    TimelessTask(String name, String status, String description, Integer id){
        this.name = name;
        this.status = status;
        this.description = description;
        this.id = id;
        this.creationTime = LocalDateTime.now();
    }

    public TimelessTask() {

    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getStatus(){
        return status;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public Integer getId() { return id; }

    @Override
    public LocalDateTime getPlannedTime() { return plannedTime; }

    @Override
    public LocalDateTime getCreationTime() { return creationTime; }


    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public void setPlannedTime(LocalDateTime plannedTime){
        this.plannedTime = plannedTime;
    }

    @Override
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
