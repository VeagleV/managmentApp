package org.project.managmentappweb.Controllers;

import org.project.managmentappweb.Entities.Tasks.Task.Task;
import org.project.managmentappweb.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully!";
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Integer userId) {
        return taskService.getTasksByUserId(userId);
    }
}