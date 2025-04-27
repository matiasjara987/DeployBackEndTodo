package com.matiasjara.dev.backend.Services;

import java.util.List;
import java.util.Optional;

import com.matiasjara.dev.backend.model.Task;

public interface ITaskService {

    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
    public List<Task> getUrgentAndImportantTasks();
    public List<Task> getNotUrgentAndImportantTasks();
    public List<Task> getUrgentAndNotImportantTasks();
    public List<Task> getNotUrgentAndNotImportantTasks();
}
