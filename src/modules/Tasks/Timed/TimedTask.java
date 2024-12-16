package modules.Tasks.Timed;

import modules.Tasks.Task;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class TimedTask extends Task {

    public static final Logger LOGGER = Logger.getLogger(TimedTask.class.getName());

    private LocalDateTime plannedTime;
    private boolean isExpired = false;

    public TimedTask(){
        super();
    }

    public TimedTask(Integer statusID, String name, String description){
        super(statusID, name, description);
    }
    public TimedTask(Integer statusID, String name, String description, LocalDateTime plannedTime){
        this(statusID, name, description);
        this.plannedTime = plannedTime;
    }


    public void setPlannedTime(LocalDateTime time){
        this.plannedTime = time;
    }

    public void updatePlannedTime(){

        LocalDateTime now = LocalDateTime.now();

        if(now.isAfter(this.plannedTime)){
            isExpired = true;
        }

        LOGGER.log(INFO,"plannedTime is updated");

    }

    public boolean isExpired(){

        LOGGER.log(INFO,"Field isExpired returned");
        updatePlannedTime();
        return isExpired;

    }

    public LocalDateTime getRemainingTime(){


        LocalDateTime difference = this.plannedTime;
        LocalDateTime now = LocalDateTime.now();

        difference.minusDays(now.getDayOfYear());
        difference.minusHours(now.getHour());
        difference.minusMinutes(now.getMinute());
        difference.minusSeconds(now.getSecond());
        difference.minusNanos(now.getNano());

        LOGGER.log(INFO,"Remaining time is Calculated");
        return difference;


    }

}
