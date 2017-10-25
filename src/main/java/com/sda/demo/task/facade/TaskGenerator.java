package com.sda.demo.task.facade;

import com.sda.demo.task.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskGenerator {

    //generator taskow
    public List<Task> generateTasks() {

        List<Task> tasks = new ArrayList<>();

        Task task = new Task();
        task.setName("Task 1");
        task.setComment("Task 1 comment");
        task.setPriority(1);

        Task task1 = new Task();
        task1.setName("Task 2");
        task1.setComment("Task 2 comment");
        task1.setPriority(2);

        tasks.add(task);
        tasks.add(task1);

        return tasks;
    }
}
