package com.matiasjara.dev.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matiasjara.dev.backend.model.Task;
import com.matiasjara.dev.backend.repositories.ITask;


@Service
public class ITaskServiceImpl implements ITaskService {

    private final ITask taskRepository;

    public ITaskServiceImpl(ITask taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
    public List<Task> getUrgentAndImportantTasks() {
        return taskRepository.findByUrgencyAndImportance(Task.Urgency.URGENTE, Task.Importance.IMPORTANTE);
    }

    public List<Task> getNotUrgentAndImportantTasks() {
        return taskRepository.findByUrgencyAndImportance(Task.Urgency.NO_URGENTE, Task.Importance.IMPORTANTE);
    }

    public List<Task> getUrgentAndNotImportantTasks() {
        return taskRepository.findByUrgencyAndImportance(Task.Urgency.URGENTE, Task.Importance.NO_IMPORTANTE);
    }

    public List<Task> getNotUrgentAndNotImportantTasks() {
        return taskRepository.findByUrgencyAndImportance(Task.Urgency.NO_URGENTE, Task.Importance.NO_IMPORTANTE);
    }

}
