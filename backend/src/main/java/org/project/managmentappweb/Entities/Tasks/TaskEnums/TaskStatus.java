package org.project.managmentappweb.Entities.Tasks.TaskEnums;


public enum TaskStatus {
    PLANNED,
    IN_PROGRESS,
    DELAYED,
    EXPIRED,
    BLOCKED,
    DONE;

    public static TaskStatus initStatus(Integer id) {
        return TaskStatus.values()[id];
    }


}



