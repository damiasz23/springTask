package com.sda.demo.tasks.controller;

import com.sda.demo.tasks.facade.TaskFacade;
import com.sda.demo.tasks.facade.TaskGenerator;
import com.sda.demo.tasks.model.Task;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @RequestMapping("/new")
    public ModelAndView newTaskForm(ModelAndView modelAndView){
        modelAndView.addObject("taks", new Task());
        modelAndView.setViewName("taskForm");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewTask(@Valid @ModelAttribute("task") Task task,  ModelAndView modelAndView){
        taskFacade.save(task);
        modelAndView.addObject("tasks", taskFacade.findAll());
        modelAndView.setViewName("list");
        return modelAndView;

    }

    @RequestMapping("/delete")
    public ModelAndView deleteTask(@RequestParam("id") String id, ModelAndView modelAndView){
        Long taksId = Long.parseLong(id);
        taskFacade.deleteTask(taksId);
        return prepereTaskList(modelAndView);
    }

    private ModelAndView prepereTaskList(ModelAndView modelAndView){
        modelAndView.addObject("tasks", taskFacade.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
