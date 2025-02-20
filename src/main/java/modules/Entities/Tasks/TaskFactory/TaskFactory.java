package modules.Entities.Tasks.TaskFactory;

import modules.Entities.Tasks.Task.Task;
import modules.Entities.Tasks.TaskEnums.*;
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
            case TASK -> {
                task = new Task();
            }
        }

        return task;
    }

    public Task createTask(TaskType type, Integer statusID, String name, String description){

        Task task = null;

        switch (type) {
            case TASK -> {
                task = new Task(statusID, name, description);
            }
        }

        return task;
    }
    //----------------------TASKCREATORS----------------------
}
