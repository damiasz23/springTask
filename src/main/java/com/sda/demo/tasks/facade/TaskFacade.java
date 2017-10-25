package com.sda.demo.tasks.facade;

import com.sda.demo.tasks.model.Task;
import com.sda.demo.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskFacade {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return (List<Task>)taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }
}
