package ru.shadrag.hw12.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shadrag.hw12.components.Priority;
import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;
import ru.shadrag.hw12.services.interfaces.TasksService;
import ru.shadrag.hw12.services.interfaces.UsersService;

import java.util.List;

@Getter
@Service
public class FacadeServiceImpl implements FacadeService {

    private final TasksService tasksService;
    private final UsersService usersService;
    private final TaskFactory taskFactory;

    @Autowired
    public FacadeServiceImpl(TasksService tasksService, UsersService usersService, TaskFactory taskFactory) {
        this.tasksService = tasksService;
        this.usersService = usersService;
        this.taskFactory = taskFactory;
    }

    public List<Task> getAllTasks() {
        return tasksService.getAllTasks();
    }

    public Task getTaskById(Long id) {
        return tasksService.getTaskById(id);
    }

    public Task createTask(Task task) {
        Task newTask;
        if (task.getPriority() == Priority.HIGH_PRIORITY)
            newTask = taskFactory.createUrgentTask(task);
        else
            newTask = taskFactory.createRegularTask(task);
        return tasksService.createTask(newTask);
    }


    public Task updateTask(Long id, Task task, User user) {
        Task updatedTask = taskFactory.udateTask(id, task, user);
        return tasksService.updateTask(updatedTask);
    }

    public void deleteTask(Long id) {
        tasksService.deleteTask(id);
    }

    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    public User getUserById(Long id) {
        return usersService.getUserById(id);
    }

    public User createUser(User user) {
        return usersService.createUser(user);
    }

    public void deleteUser(Long id) {
        usersService.deleteUser(id);
    }
}
