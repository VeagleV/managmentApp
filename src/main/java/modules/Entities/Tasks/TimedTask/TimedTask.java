package modules.Entities.Tasks.TimedTask;

import modules.Entities.Tasks.Task.Task;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

@Entity
@DiscriminatorValue("TimedTask")
public class TimedTask extends Task {

    public static final Logger LOGGER = Logger.getLogger(TimedTask.class.getName());

    @Column(name="plannedTime")
    private LocalDateTime plannedTime;

    public boolean isExpired = false;

    //----------------------CONSTRUCTORS----------------------
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
    //----------------------CONSTRUCTORS----------------------

    //----------------------SETTERS/GETTERS----------------------
    public void setPlannedTime(LocalDateTime time){
        this.plannedTime = time;
    }

    public LocalDateTime getRemainingTime(){
        LocalDateTime difference = this.plannedTime;
        LocalDateTime now = LocalDateTime.now();

        difference = difference.minusDays(now.getDayOfYear());
        difference = difference.minusHours(now.getHour());
        difference = difference.minusMinutes(now.getMinute());
        difference = difference.minusSeconds(now.getSecond());
        difference = difference.minusNanos(now.getNano());

        LOGGER.log(INFO, "Remaining time has been Calculated");
        return difference;
    }

    public boolean isExpired(){
        LOGGER.log(INFO,"Field isExpired returned");
        if (this.plannedTime.isBefore(LocalDateTime.now())) {
            this.isExpired = true;
        }
        return isExpired;
    }
    //----------------------SETTERS/GETTERS----------------------



}
