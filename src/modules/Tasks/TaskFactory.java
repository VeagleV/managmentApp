package modules.Tasks;
import modules.Tasks.Timed.TimedTask;
import modules.Tasks.Timeless.TimelessTask;




public class TaskFactory {
    public Task createTask(TaskType type) {
        Task task = null;

        switch (type) {
            case TIMED_TASK -> task = new TimedTask();
            case TIMELESS_TASK -> task = new TimelessTask();
        }

        return task;
    }

    public Task createTask(TaskType type, Integer statusID, String name, String description){

        Task task = null;

        switch (type){
            case TIMED_TASK -> task = new TimedTask(statusID, name, description);
            case TIMELESS_TASK -> task = new TimelessTask(statusID, name, description);
        }


        return task;
    }

}
