package com.sda.demo.tasks.controller;

import com.sda.demo.tasks.facade.TaskFacade;
import com.sda.demo.tasks.facade.TaskGenerator;
import com.sda.demo.tasks.model.Task;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskFacade taskFacade;

    @Autowired
    private TaskGenerator taskGenerator;

    @RequestMapping("/hello")
    public ModelAndView getHelloWorld(ModelAndView modelAndView) {
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/tasks")
    public ModelAndView getTasks(ModelAndView modelAndView) {
        List<Task> tasks = taskFacade.findAll();
        modelAndView.addObject("tasks",tasks);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/generateData")
    @ResponseBody
    public String generateData() {
        List<Task> tasks = taskGenerator.generateTasks();
        for (Task task : tasks) {
            taskFacade.save(task);
        }
        return "Data generated";
    }
}
