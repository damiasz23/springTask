package com.sda.demo.tasks.controller;

import com.sda.demo.tasks.facade.TaskFacade;
import com.sda.demo.tasks.facade.TaskGenerator;
import com.sda.demo.tasks.model.Task;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
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
        return prepareTaskList(modelAndView);
    }

    @RequestMapping("/new")
    public ModelAndView newTaskForm(ModelAndView modelAndView) {
        modelAndView.addObject("task", new Task());
        modelAndView.setViewName("taskForm");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView deleteTask(@RequestParam("id") String id, ModelAndView modelAndView) {
        Long taskId = Long.parseLong(id);
        taskFacade.deleteTask(taskId);
        return prepareTaskList(modelAndView);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewTask(@Valid @ModelAttribute("task") Task task, ModelAndView modelAndView) {
        taskFacade.save(task);
        return prepareTaskList(modelAndView);
    }
    @RequestMapping("/edit")
    public ModelAndView editTask(@RequestParam("id") String id, ModelAndView modelAndView){
        Task task = taskFacade.findTaskById(Long.parseLong(id));
        modelAndView.addObject("task", task);
        modelAndView.setViewName("taskForm");
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

    private ModelAndView prepareTaskList(ModelAndView modelAndView) {
        modelAndView.addObject("tasks", taskFacade.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
