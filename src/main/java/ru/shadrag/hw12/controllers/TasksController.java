package ru.shadrag.hw12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shadrag.hw12.components.Status;
import ru.shadrag.hw12.domain.FacadeService;
import ru.shadrag.hw12.models.User;
import ru.shadrag.hw12.models.Task;

import java.util.Date;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private boolean onIndexPage;

    private final FacadeService facadeService;

    @Autowired
    public TasksController(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @RequestMapping(value = "/all-tasks", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("buttonStat", Status.ALL_TASKS);
        model.addAttribute("tasks", facadeService.getAllTasks());
        onIndexPage = true;
        return "tasks-views/all-tasks";
    }

    @RequestMapping(value = "/all-tasks/{id}/{status}", method = RequestMethod.GET)
    public String updateStatus(@PathVariable("status") Status status, @PathVariable("id") Long id) {
        Task task = facadeService.getTaskById(id);
        Status sortStatus = task.getStatus();
        task.setStatus(status);
        task.setDate(new Date());
        facadeService.updateTask(task.getId(), task, task.getUser());
        if (onIndexPage)
            return "redirect:/tasks/all-tasks";
        else
            return "redirect:/tasks/sort-tasks/" + sortStatus;
    }

    @RequestMapping(value = "/update-task/{id}", method = RequestMethod.GET)
    public String updateTask(@PathVariable("id") Long id, @RequestParam(value = "userId", defaultValue = "-1") Long userId, Model model) {
        User tmpUser = facadeService.getUserById(userId);
        Task tmpTask = facadeService.getTaskById(id);
        if (tmpUser != null)
            tmpTask.setUser(tmpUser);
        model.addAttribute("userId", userId);
        model.addAttribute("task", tmpTask);
        model.addAttribute("users", facadeService.getAllUsers());
        return "tasks-views/update-task";
    }

    @RequestMapping(value = "/update-task/{id}", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("task") Task task, @PathVariable("id") Long id, @RequestParam(value = "userId") Long userId) {
        facadeService.updateTask(id, task, facadeService.getUserById(userId));
        if (onIndexPage)
            return "redirect:/tasks/all-tasks";
        else
            return "redirect:/tasks/sort-tasks/" + facadeService.getTaskById(id).getStatus();
    }


    @RequestMapping(value = "/create-task", method = RequestMethod.GET)
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "tasks-views/create-task";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String createTask(@ModelAttribute("task") Task task) {
        facadeService.createTask(task);
        return "redirect:/tasks/all-tasks";
    }

    @RequestMapping(value = "/delete-task/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") Long id) {
        facadeService.deleteTask(id);
        return "redirect:/tasks/all-tasks";
    }

    @RequestMapping(value = "/sort-tasks/{status}", method = RequestMethod.GET)
    public String sortTaskByStatus(@PathVariable("status") Status status, Model model) {
        onIndexPage = false;
        model.addAttribute("buttonStat", status);
        model.addAttribute("tasks", facadeService.getAllTasks().stream().filter(it -> it.getStatus() == status));
        return "tasks-views/all-tasks";
    }

}
