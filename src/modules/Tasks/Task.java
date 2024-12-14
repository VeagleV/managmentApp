package modules.Tasks;

import java.time.LocalDateTime;

public abstract class Task {


    public String getName();
    public String getStatus();
    public String getDescription();
    public Integer getId();

    public LocalDateTime getPlannedTime();

    public LocalDateTime getCreationTime();

    public void setName(String name);
    public void setStatus(String status);
    public void setDescription(String description);
    public void setPlannedTime(LocalDateTime plannedTime);

    public boolean isExpired();

//    default void updateTime(){
//
//        LocalDateTime currentTime= LocalDateTime.now();
//
//        if(plannedTime.isAfter(currentTime)){
//            isExpired = true;
//            status = "Expired";
//
//        }
//    }

}
