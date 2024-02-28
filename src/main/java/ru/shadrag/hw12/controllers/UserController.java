package ru.shadrag.hw12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shadrag.hw12.domain.FacadeService;
import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    
    private final FacadeService facadeService;

    @Autowired
    public UserController(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public String indexUsers(Model model) {
        model.addAttribute("users", facadeService.getAllUsers());
        return "users-views/all-users";
    }

    @RequestMapping(value = "/set-task", method = RequestMethod.GET)
    public String setTaskForUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("tasks", facadeService.getAllTasks().stream().filter(it -> it.getUser() == null).toList());
        model.addAttribute("user", facadeService.getUserById(id));
        return "users-views/set-task";
    }

    @RequestMapping(value = "/set-task", method = RequestMethod.POST)
    public String setTaskForUser(@RequestParam("id") Long id, @RequestParam("taskId") Long taskId) {
        User user = facadeService.getUserById(id);
        Task task = facadeService.getTaskById(taskId);
        user.getUserTasksList().add(facadeService.getTaskById(taskId));
        facadeService.updateTask(taskId, task, user);
        return "redirect:/users/all-users";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "users-views/create-user";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        facadeService.createUser(user);
        return "redirect:/users/all-users";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long id) {
        facadeService.deleteUser(id);
        return "redirect:/users/all-users";
    }
}