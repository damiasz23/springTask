package com.sda.demo.task.controller;

import com.sda.demo.task.facade.TaskFacade;
import com.sda.demo.task.facade.TaskGenerator;
import com.sda.demo.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    //wstrzykujemy TaskFacade - zawsze adnotacja @autowired jak chcesz coś "wstrzyknac"
    @Autowired
    private TaskFacade taskFacade;

    @Autowired
    private TaskGenerator taskGenerator;

    @RequestMapping("/hello")
    public ModelAndView getHelloWorld(ModelAndView modelAndView) {
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    //teraz tzw "end point" aby wywolac nasz generator taskow
    @RequestMapping("/generateData")  //mapowanie na tworzenie Taskow
    @ResponseBody
    public String generateData() {
        List<Task> tasks = taskGenerator.generateTasks();
        for (Task task : tasks) {
            taskFacade.save(task);
        }
        return "Data generated";
    }

    @RequestMapping("/tasks")
    public ModelAndView getTask(ModelAndView modelAndView) {
        List<Task> tasks = taskFacade.findAll();
        modelAndView.addObject("tasks", tasks);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
