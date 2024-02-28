package ru.shadrag.hw12.services.interfaces;

import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

import java.util.List;

public interface TasksService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Task updatedTask);
    void deleteTask(Long id);
}
