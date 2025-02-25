package org.project.managmentappweb.Services;

import org.project.managmentappweb.Entities.Tasks.Task.Task;
import org.project.managmentappweb.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.findByUserId(userId); // Если добавите такой метод в TaskRepository
    }
}