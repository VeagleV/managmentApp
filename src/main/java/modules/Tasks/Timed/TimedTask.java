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

        //TODO: переписать нахуй чтобы нормально работало, а не от вызова функции(выделить 1 поток для расчёта времени для всех тасков)

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

        difference = difference.minusDays(now.getDayOfYear());
        difference = difference.minusHours(now.getHour());
        difference = difference.minusMinutes(now.getMinute());
        difference = difference.minusSeconds(now.getSecond());
        difference = difference.minusNanos(now.getNano());

        LOGGER.log(INFO,"Remaining time is Calculated");
        return difference;


    }

}
