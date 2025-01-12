package modules.Tasks;
import modules.Tasks.Timed.TimedTask;
import modules.Tasks.Timeless.TimelessTask;

import java.util.logging.Level;
import java.util.logging.Logger;



public class TaskFactory {
    public static final Logger LOGGER = Logger.getLogger(TaskFactory.class.getName());

    public TaskFactory(){
        LOGGER.log(Level.INFO,"Instance of TaskFactory Created");
    }

    //----------------------TASKCREATORS----------------------
    public Task createTask(TaskType type) {
        Task task = null;

        switch (type) {
            case TIMED_TASK -> {
                task = new TimedTask();
                LOGGER.log(Level.INFO,"Instance of TimedTask created(empty)");
            }
            case TIMELESS_TASK -> {
                task = new TimelessTask();
                LOGGER.log(Level.INFO,"Instance of TimelessTask created(empty)");
            }
        }

        return task;
    }

    public Task createTask(TaskType type, Integer statusID, String name, String description){

        Task task = null;

        switch (type){
            case TIMED_TASK -> {
                task = new TimedTask(statusID, name, description);
                LOGGER.log(Level.INFO,"Instance of TimedTask created(with name and description)");
            }
            case TIMELESS_TASK -> {
                task = new TimelessTask(statusID, name, description);
                LOGGER.log(Level.INFO,"Instance of TimelessTask created(with name and description)");
            }
        }

        return task;
    }
    //----------------------TASKCREATORS----------------------
}
