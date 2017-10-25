package com.sda.demo.task.facade;

import com.sda.demo.task.model.Task;
import com.sda.demo.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //musi byc taka adnotacja lub np @Control jezeli bedziemy chcieli cos wstrzykiwac :)
public class TaskFacade {

    //wstrzykujemy interfejs
    @Autowired
    private TaskRepository taskRepository;

    //szuka wszystkich taskow
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    //metoda zapisuje obiekty task w bazie danych
    public void save(Task task) {
        taskRepository.save(task);
    }
}
