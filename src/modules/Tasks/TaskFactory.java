package modules.Tasks;

import modules.Tasks.Timed.TimedTask;
import modules.Tasks.Timeless.TimelessTask;

public class TaskFactory {
    public Task createTask(TaskType type){
        Task task = null;

        switch(type){
            case TIMED_TASK -> task = new TimedTask();
            case TIMELESS_TASK -> task = new TimelessTask();
        }

        return task;
    }
}
