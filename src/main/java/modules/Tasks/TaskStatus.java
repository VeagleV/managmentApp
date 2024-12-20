package modules.Tasks;


import java.util.HashMap;

public enum TaskStatus {
    PLANNED,
    IN_PROGRESS,
    DELAYED,
    EXPIRED,
    BLOCKED,
    DONE;

    public TaskStatus initStatus(Integer id){

        return TaskStatus.values()[id];
    }


}



