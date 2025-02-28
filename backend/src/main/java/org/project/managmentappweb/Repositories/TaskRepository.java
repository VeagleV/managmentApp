package org.project.managmentappweb.Repositories;

import org.project.managmentappweb.Entities.Tasks.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Здесь можно добавить дополнительные методы поиска, если потребуется

    List<Task> findByUserId(int userId);
}