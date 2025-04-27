package com.matiasjara.dev.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matiasjara.dev.backend.model.Task;
@Repository
public interface ITask extends CrudRepository<Task, Long> {

    List<Task> findByUrgencyAndImportance(Task.Urgency urgency, Task.Importance importance);
}
