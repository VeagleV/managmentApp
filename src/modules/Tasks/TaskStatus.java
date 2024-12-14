package modules.Tasks;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public enum TaskStatus {
    PLANNED,
    IN_PROGRESS,
    DELAYED,
    EXPIRED,
    BLOCKED,
    DONE;

    @NotNull
    public TaskStatus initStatus(Integer id){

        return TaskStatus.values()[id];
    }


}



