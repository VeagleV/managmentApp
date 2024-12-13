package modules;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.ArrayList;
abstract public  class Mediator {

    private static final HashMap<Integer, String> status = new HashMap<>(){
        {
            put(1, "In Progress");
            put(2, "To do");
            put(3, "Planned");
            put(4, "Blocked");
            put(5, "Expired");
            put(6, "Done");

        }

    };
    public static @NotNull Task getTask(Integer id, ArrayList<Task> listOfTasks) {

        for (Task currentTask : listOfTasks) {

            if (id.equals(currentTask.getId())) {

                return currentTask;

            }

        }

        throw new RuntimeException("There is no such task");

    }

    public static @NotNull Integer getTaskId(String name, ArrayList<Task> listOfTasks){

        for (Task currentTask : listOfTasks){

            if(name.equals(currentTask.getName())){
                return currentTask.getId();
            }
        }

        throw new RuntimeException("There is no such task");

    }

    public static void  updateTask(Task task,  ArrayList<Task> listOfTasks) {

        for(int i = 0; i < listOfTasks.size(); i++){

            Task currentTask = listOfTasks.get(i);

            if(task.getId().equals(currentTask.getId())){
                listOfTasks.set(i, task);
                return;
            }

        }
        throw new RuntimeException("There is no such Task");

    }

    public static void updateTaskStatus(Integer id, Integer newStatus, ArrayList<Task> listOfTasks){

        Task currentTask = getTask(id, listOfTasks);

        currentTask.setStatus(status.get(newStatus));

    }
}
