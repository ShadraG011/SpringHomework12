package ru.shadrag.hw12.domain;

import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

import java.util.List;

public interface FacadeService {
    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task createTask(Task task);

    Task updateTask(Long id, Task task, User user);

    void deleteTask(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    void deleteUser(Long id);
}
